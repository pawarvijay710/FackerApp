package com.vjypwr.home.data.model.response.product


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: List<ProductData>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total")
    val total: Int?
)