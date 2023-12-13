package com.vjypwr.home.domain.model.response.book

data class BookLocalResponse(
    val code: Int?,
    val `data`: List<BookDataLocal>?,
    val status: String?,
    val total: Int?
)