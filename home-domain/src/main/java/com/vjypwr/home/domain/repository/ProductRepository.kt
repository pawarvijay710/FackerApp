package com.vjypwr.home.domain.repository

import com.vjypwr.home.domain.model.response.product.ProductLocalResponse

interface ProductRepository {
    fun getProducts(quantity: Int?): ProductLocalResponse
}