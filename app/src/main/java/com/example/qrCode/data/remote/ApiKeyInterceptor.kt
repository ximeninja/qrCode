package com.example.qrCode.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newRequest = original.newBuilder()
            .addHeader("x-api-key", "VVTUTAdalB55yRKQzsM7u6RTowrcUUhJLA82hoN6")
            .build()
        return chain.proceed(newRequest)
    }
}
