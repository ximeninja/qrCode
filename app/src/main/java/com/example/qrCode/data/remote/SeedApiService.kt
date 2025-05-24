package com.example.qrCode.data.remote

import com.example.qrCode.data.model.Seed
import retrofit2.http.GET

interface SeedApiService {
    @GET("/default/random-qr-seed_seed")
    suspend fun getSeed(): Seed
}
