package com.example.qrCode.di

import com.example.qrCode.data.SeedRepository
import com.example.qrCode.data.remote.ApiKeyInterceptor
import com.example.qrCode.data.remote.SeedApiService
import com.example.qrCode.ui.list.QrCodeViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<Interceptor> { ApiKeyInterceptor() }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://8mpaf1q1g5.execute-api.us-west-1.amazonaws.com")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<SeedApiService> {
        get<Retrofit>().create(SeedApiService::class.java)
    }

    single { SeedRepository(get()) }

    viewModel { QrCodeViewModel(get()) }
}
