package com.vjypwr.home.data.repositoryimpl

import com.vjypwr.home.data.datasource.ProductDataSource
import com.vjypwr.home.data.mapper.ProductApiToLocalMapper
import com.vjypwr.home.domain.model.response.product.ProductLocalResponse
import com.vjypwr.home.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource,
    private val mapper: ProductApiToLocalMapper
) : ProductRepository {
    override fun getProducts(quantity: Int?): ProductLocalResponse {
        return mapper.toLocal(productDataSource.getProducts(quantity))
    }
}