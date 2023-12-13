package com.vjypwr.login.data.mapper

import com.vjypwr.login.data.model.response.LoginResponse
import com.vjypwr.login.domain.model.response.LoginLocalResponse
import javax.inject.Inject


class LoginApiToLocalMapper @Inject constructor() {
    fun toLocal(apiResponse: LoginResponse): LoginLocalResponse {
        return LoginLocalResponse(apiResponse.status, apiResponse.message)
    }
}