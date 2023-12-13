package com.vjypwr.login.domain.repository

import com.vjypwr.login.domain.model.request.LoginLocalRequest
import com.vjypwr.login.domain.model.response.LoginLocalResponse

interface LoginRepository {
    fun login(request: LoginLocalRequest): LoginLocalResponse
}