package com.vjypwr.login.data.api

import com.vjypwr.login.data.model.request.LoginRequest
import com.vjypwr.login.data.model.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiService {
    @POST("/login")
    fun login(
        @Body request: LoginRequest
    ): Call<LoginResponse>
}