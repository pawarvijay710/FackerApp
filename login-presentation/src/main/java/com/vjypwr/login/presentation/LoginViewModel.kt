package com.vjypwr.login.presentation

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.common.UseCaseExecutor
import com.example.domain.common.model.UseCaseResult
import com.vjypwr.login.domain.model.request.LoginLocalRequest
import com.vjypwr.login.domain.usecase.LoginUseCase
import com.vjypwr.common.ui.R
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val resources: Resources,
    private val useCaseExecutor: UseCaseExecutor,
    private val loginUseCase: LoginUseCase
): ViewModel() {
    private val _isValidInput = MutableLiveData<Boolean>()
    val isValidInput: LiveData<Boolean> = _isValidInput

    private val _loginMessage = MutableLiveData<String>()
    val loginMessage: LiveData<String> = _loginMessage

    private val _loginSuccessful = MutableLiveData<Boolean>()
    val loginSuccessful: LiveData<Boolean> = _loginSuccessful

    fun validate(username: String, password: String) {
        _isValidInput.value = (username.isNotEmpty() && password.isNotEmpty())
    }

    fun callUserLoginApi(username: String, password: String) {
        val request = getLoginRequest(username, password)
        useCaseExecutor.execute(loginUseCase, request) { loginResult ->
            if (loginResult is UseCaseResult.Success) {
                if (loginResult.data.status == 200) {
                    _loginSuccessful.value = true
                    _loginMessage.value = loginResult.data.message
                } else {
                    _loginSuccessful.value = false
                    _loginMessage.value = resources.getString(R.string.something_went_wrong)
                }
            } else if (loginResult is UseCaseResult.Failure) {
                _loginSuccessful.value = false
                _loginMessage.value = resources.getString(R.string.something_went_wrong)
            }
        }
    }

    private fun getLoginRequest(username: String, password: String): LoginLocalRequest {
        return LoginLocalRequest(username, password)
    }
}