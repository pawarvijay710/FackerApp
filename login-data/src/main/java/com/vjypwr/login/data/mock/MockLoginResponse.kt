package com.vjypwr.login.data.mock

import com.vjypwr.login.data.model.response.LoginResponse

class MockLoginResponse {
    fun getLoginApiResponse() = LoginResponse(200, "Login Successful!!")
}