package com.example.qrCode.ui.qrCode

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrCode.data.SeedRepository
import com.example.qrCode.data.model.Seed
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class UiState {
    object Loading : UiState()
    data class Success(val seed: Seed) : UiState()
    data class Error(val message: String) : UiState()
}

class QrCodeViewModel(
    private val repository: SeedRepository
) : ViewModel() {

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _qrBitmap = MutableStateFlow<Bitmap?>(null)
    val qrBitmap: StateFlow<Bitmap?> = _qrBitmap

    init {
        getSeed()
    }

    private fun generateQrFromSeed(seed: String) {
        viewModelScope.launch {
            try {
                val size = 512
                val bitMatrix = MultiFormatWriter().encode(seed, BarcodeFormat.QR_CODE, size, size)
                val bitmap = BarcodeEncoder().createBitmap(bitMatrix)
                _qrBitmap.value = bitmap
            } catch (e: Exception) {
                _qrBitmap.value = null
            }
        }
    }

    private fun getSeed() {
        viewModelScope.launch {
            try {
                val seed = repository.getSeed()
                generateQrFromSeed(seed.seed)
            } catch (e: Exception) {
                _error.value = "Failed to load items"
            }
        }
    }
}
