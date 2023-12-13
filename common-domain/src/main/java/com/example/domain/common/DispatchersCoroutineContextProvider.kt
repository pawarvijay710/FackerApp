package com.example.domain.common

import kotlinx.coroutines.Dispatchers

class DispatchersCoroutineContextProvider : CoroutineContextProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
}