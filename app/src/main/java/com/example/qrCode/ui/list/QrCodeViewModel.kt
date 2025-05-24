package com.example.qrCode.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrCode.data.SeedRepository
import com.example.qrCode.data.model.Seed
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

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        getSeed()
    }

    private fun getSeed() {
        viewModelScope.launch {
            try {
                val seed = repository.getSeed()
                _uiState.value = UiState.Success(seed)
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to load items")
            }
        }
    }
}
