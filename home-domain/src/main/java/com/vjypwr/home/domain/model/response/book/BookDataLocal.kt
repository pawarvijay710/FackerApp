package com.vjypwr.home.domain.model.response.book

data class BookDataLocal(
    val author: String?,
    val description: String?,
    val genre: String?,
    val id: Int?,
    val image: String?,
    val isbn: String?,
    val published: String?,
    val publisher: String?,
    val title: String?
)