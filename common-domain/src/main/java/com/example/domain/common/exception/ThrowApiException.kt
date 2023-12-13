package com.example.domain.common.exception

abstract class ThrowApiException(throwable: Throwable? = null) : IllegalStateException(throwable)