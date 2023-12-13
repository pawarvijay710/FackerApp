package com.example.data.common.intercepters

import android.os.Build
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

private const val APP_LOGIN_SERVICE = "login_service"
private const val APP_SERVICE = "app_service"

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var apiService: String? = null

        val requestBuilder = chain.request().newBuilder()
        val userAgent = "systemName:Android, systemVersion:${Build.VERSION.SDK_INT}"

        apiService = when {
            chain.request().url().toString().endsWith("login") -> {
                APP_LOGIN_SERVICE
            }
            else -> APP_SERVICE
        }

        when (apiService) {
            APP_LOGIN_SERVICE -> {
                setAppComponentHeaders(requestBuilder, userAgent)
                requestBuilder.addHeader("X-Channel-Id", "login")
            }
            APP_SERVICE -> {
                setAppComponentHeaders(requestBuilder, userAgent)
            }
        }
        val request = requestBuilder.build()
        return chain.proceed(request)
    }

    private fun setAppComponentHeaders(requestBuilder: Request.Builder, userAgent: String) {
        requestBuilder.addHeader("Accept", "*/*")
            .addHeader("Content-Type", "application/json")
            .addHeader("Cache-Control", "no-cache,no-cache")
            .addHeader("userAgent", userAgent)
    }
}