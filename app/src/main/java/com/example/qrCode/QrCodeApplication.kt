package com.example.qrCode

import android.app.Application
import com.example.qrCode.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QrCodeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@QrCodeApplication)
            modules(appModule)
        }
    }
}
