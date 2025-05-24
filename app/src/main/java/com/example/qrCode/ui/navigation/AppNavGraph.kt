package com.example.qrCode.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qrCode.ui.qrCode.QrCodeScreen
import com.example.qrCode.ui.home.HomeScreen
import com.example.qrCode.ui.scan.ScanScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(navController)
        }

        composable(Routes.QR) {
            QrCodeScreen()
        }

        composable(Routes.SCAN) {
            ScanScreen(
                onCodeScanned = {
                    navController.popBackStack(Routes.HOME, inclusive = false)
                }
            )
        }
    }
}
