package com.example.qrCode.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun QrCodeScreen(navController: NavController, viewModel: QrCodeViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UiState.Loading ->  Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        is UiState.Error -> {
            val message = (uiState as UiState.Error).message
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = message)
            }
        }
        is UiState.Success -> {
            val seed = (uiState as UiState.Success).seed.seed
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = seed)
            }
        }
    }
}
