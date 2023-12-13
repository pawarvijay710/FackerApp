package com.example.data.common.intercepters

import okhttp3.Interceptor
import javax.inject.Inject

class MetaHeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain) = getInterceptor().intercept(chain)

    private fun getInterceptor(): HeaderInterceptor {
        return HeaderInterceptor()
    }
}