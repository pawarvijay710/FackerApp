package com.vjypwr.home.domain.usecase

import com.example.domain.common.BackGroundExecuteUseCase
import com.example.domain.common.CoroutineContextProvider
import com.vjypwr.home.domain.model.response.product.ProductLocalResponse
import com.vjypwr.home.domain.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    coroutineContextProvider: CoroutineContextProvider,
    private val repository: ProductRepository,
) : BackGroundExecuteUseCase<Int, ProductLocalResponse>(coroutineContextProvider) {
    override suspend fun executeInBackground(
        value: Int, coroutineScope: CoroutineScope
    ) = repository.getProducts(value)
}