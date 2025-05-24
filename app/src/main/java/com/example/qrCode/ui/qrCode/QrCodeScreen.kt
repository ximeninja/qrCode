package com.example.qrCode.ui.qrCode

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun QrCodeScreen(viewModel: QrCodeViewModel = koinViewModel()) {
    val qrBitmap by viewModel.qrBitmap.collectAsState()
    val error by viewModel.error.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            qrBitmap != null -> {
                Image(
                    bitmap = qrBitmap!!.asImageBitmap(),
                    contentDescription = "QR Code",
                    modifier = Modifier.size(256.dp)
                )
            }
            error != null -> {
                Text("Error: $error")
            }
            else -> {
                CircularProgressIndicator()
            }
        }
    }
}
