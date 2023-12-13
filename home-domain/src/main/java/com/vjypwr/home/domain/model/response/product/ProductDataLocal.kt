package com.vjypwr.home.domain.model.response.product

data class ProductDataLocal(
    val categories: List<String>?,
    val description: String?,
    val ean: String?,
    val id: Int?,
    val image: String?,
    val images: List<ProductImageLocal>?,
    val name: String?,
    val netPrice: Double?,
    val price: String?,
    val tags: List<String>?,
    val taxes: String?,
    val upc: String?
)