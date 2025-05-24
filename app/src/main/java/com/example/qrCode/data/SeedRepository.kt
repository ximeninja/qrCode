package com.example.qrCode.data

import com.example.qrCode.data.model.Seed
import com.example.qrCode.data.remote.SeedApiService

class SeedRepository(private val apiService: SeedApiService) {
    suspend fun getSeed(): Seed = apiService.getSeed()
}
