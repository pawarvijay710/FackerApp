package com.vjypwr.home.data.model.response.book


import com.google.gson.annotations.SerializedName

data class BookData(
    @SerializedName("author")
    val author: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("genre")
    val genre: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("isbn")
    val isbn: String?,
    @SerializedName("published")
    val published: String?,
    @SerializedName("publisher")
    val publisher: String?,
    @SerializedName("title")
    val title: String?
)