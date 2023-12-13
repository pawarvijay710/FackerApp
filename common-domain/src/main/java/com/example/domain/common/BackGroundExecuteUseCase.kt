package com.example.domain.common

import com.example.domain.common.model.UseCaseResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

abstract class BackGroundExecuteUseCase<INPUT_TYPE, OUTPUT_TYPE> constructor(
    private val coroutineContextProvider: CoroutineContextProvider
) : BaseUseCase<INPUT_TYPE, OUTPUT_TYPE>() {

    final override suspend fun execute(
        value: INPUT_TYPE,
        callback: (UseCaseResult<OUTPUT_TYPE>) -> Unit
    ) {
        val result = withContext(coroutineContextProvider.io) {
            try {
                UseCaseResult.Success(executeInBackground(value, this))
            } catch (throwable: Throwable) {
                UseCaseResult.Failure<OUTPUT_TYPE>(throwable)
            }
        }

        callback(result)
    }

    abstract suspend fun executeInBackground(
        value: INPUT_TYPE,
        coroutineScope: CoroutineScope
    ): OUTPUT_TYPE
}