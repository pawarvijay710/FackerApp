package com.vjypwr.login.domain.usecase

import com.example.domain.common.BackGroundExecuteUseCase
import com.example.domain.common.CoroutineContextProvider
import com.vjypwr.login.domain.model.request.LoginLocalRequest
import com.vjypwr.login.domain.model.response.LoginLocalResponse
import com.vjypwr.login.domain.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    coroutineContextProvider: CoroutineContextProvider,
    private val repository: LoginRepository
) : BackGroundExecuteUseCase<LoginLocalRequest, LoginLocalResponse>(coroutineContextProvider) {
    override suspend fun executeInBackground(
        value: LoginLocalRequest,
        coroutineScope: CoroutineScope
    ): LoginLocalResponse = repository.login(value)
}