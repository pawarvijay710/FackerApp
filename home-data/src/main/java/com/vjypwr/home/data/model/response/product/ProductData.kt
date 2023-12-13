package com.vjypwr.home.data.model.response.product


import com.google.gson.annotations.SerializedName

data class ProductData(
    @SerializedName("categories")
    val categories: List<String>?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("ean")
    val ean: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("images")
    val images: List<ProductImage>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("net_price")
    val netPrice: Double?,
    @SerializedName("price")
    val price: String?,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("taxes")
    val taxes: String?,
    @SerializedName("upc")
    val upc: String?
)