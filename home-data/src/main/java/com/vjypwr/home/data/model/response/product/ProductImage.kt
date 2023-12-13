package com.vjypwr.home.data.model.response.product


import com.google.gson.annotations.SerializedName

data class ProductImage(
    @SerializedName("description")
    val description: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?
)