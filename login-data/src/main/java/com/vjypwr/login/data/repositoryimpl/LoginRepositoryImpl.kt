package com.vjypwr.login.data.repositoryimpl

import com.vjypwr.login.data.datasource.LoginDataSource
import com.vjypwr.login.data.mapper.LoginApiToLocalMapper
import com.vjypwr.login.data.model.request.LoginRequest
import com.vjypwr.login.domain.model.request.LoginLocalRequest
import com.vjypwr.login.domain.model.response.LoginLocalResponse
import com.vjypwr.login.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource,
    private val mapper: LoginApiToLocalMapper
) : LoginRepository {
    override fun login(request: LoginLocalRequest): LoginLocalResponse {
        val apiRequest = LoginRequest(request.username, request.password)
        return mapper.toLocal(loginDataSource.login(apiRequest))
    }
}