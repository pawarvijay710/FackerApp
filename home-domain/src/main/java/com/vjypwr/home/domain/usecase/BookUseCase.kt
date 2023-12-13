package com.vjypwr.home.domain.usecase

import com.example.domain.common.BackGroundExecuteUseCase
import com.example.domain.common.CoroutineContextProvider
import com.vjypwr.home.domain.model.response.book.BookLocalResponse
import com.vjypwr.home.domain.repository.BookRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class BookUseCase @Inject constructor(
    coroutineContextProvider: CoroutineContextProvider,
    private val repository: BookRepository,
) : BackGroundExecuteUseCase<Int, BookLocalResponse>(coroutineContextProvider) {
    override suspend fun executeInBackground(
        value: Int, coroutineScope: CoroutineScope
    ) = repository.getBooks(value)
}