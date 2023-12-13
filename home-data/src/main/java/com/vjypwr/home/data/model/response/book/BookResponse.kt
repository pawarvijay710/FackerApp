package com.vjypwr.home.data.model.response.book


import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: List<BookData>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total")
    val total: Int?
)