package com.vjypwr.login.data.datasource

import com.example.data.common.utils.AppConstant
import com.example.data.common.utils.exception.ApiUnsuccessfulException
import com.example.domain.common.exception.ApiUnauthorizedException
import com.example.login.data.BuildConfig
import com.vjypwr.login.data.api.LoginApiService
import com.vjypwr.login.data.mock.MockLoginResponse
import com.vjypwr.login.data.model.request.LoginRequest
import com.vjypwr.login.data.model.response.LoginResponse
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class LoginDataSource @Inject constructor(private val apiService: LoginApiService) {

    fun login(request: LoginRequest): LoginResponse {
        try {
            if (BuildConfig.FLAVOR.equals(AppConstant.KEY_MOCK, ignoreCase = true)) {
                return MockLoginResponse().getLoginApiResponse()
            }
            val response = apiService.login(request).execute()
            if (!response.isSuccessful) {
                when (response.code()) {
                    HttpURLConnection.HTTP_UNAUTHORIZED -> throw ApiUnauthorizedException()
                    else -> throw ApiUnsuccessfulException()
                }
            }

            return response.body() ?: throw ApiUnsuccessfulException()
        } catch (e: IOException) {
            throw ApiUnsuccessfulException()
        }
    }
}