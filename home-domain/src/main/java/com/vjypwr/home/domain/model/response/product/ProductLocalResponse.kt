package com.vjypwr.home.domain.model.response.product

data class ProductLocalResponse(
    val code: Int?,
    val `data`: List<ProductDataLocal>?,
    val status: String?,
    val total: Int?
)