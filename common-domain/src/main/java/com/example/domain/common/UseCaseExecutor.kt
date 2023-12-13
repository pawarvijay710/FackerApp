package com.example.domain.common

import com.example.domain.common.model.UseCaseResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class UseCaseExecutor @Inject constructor(
    private val jobProvider: JobProvider,
    private val coroutineContextProvider: CoroutineContextProvider
) {
    private var uiScope = CoroutineScope(coroutineContextProvider.main + jobProvider())

    fun <OUTPUT_TYPE> execute(
        useCase: BaseUseCase<Unit, OUTPUT_TYPE>,
        callBack: (UseCaseResult<OUTPUT_TYPE>) -> Unit = {}
    ) = execute(useCase, Unit, callBack)

    fun <INPUT_TYPE, OUTPUT_TYPE> execute(
        useCase: BaseUseCase<INPUT_TYPE, OUTPUT_TYPE>,
        value: INPUT_TYPE,
        callBack: (UseCaseResult<OUTPUT_TYPE>) -> Unit = {}
    ) {
        uiScope.coroutineContext
        uiScope.launch {
            useCase.execute(value, callBack)
        }
    }

    fun stopAll() {

    }
}