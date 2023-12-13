package com.example.domain.common

import com.example.domain.common.model.UseCaseResult

abstract class BaseUseCase<INPUT_TYPE, OUTPUT_TYPE> {
    abstract suspend fun execute(value: INPUT_TYPE, callback: (UseCaseResult<OUTPUT_TYPE>) -> Unit)

}