package com.example.qrCode.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qrCode.ui.qrCode.QrCodeScreen
import com.example.qrCode.ui.home.HomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }

        composable("qrcode") {
            QrCodeScreen()
        }
    }
}
