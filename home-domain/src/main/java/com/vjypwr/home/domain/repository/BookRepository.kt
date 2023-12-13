package com.vjypwr.home.domain.repository

import com.vjypwr.home.domain.model.response.book.BookLocalResponse

interface BookRepository {
    fun getBooks(quantity: Int?): BookLocalResponse
}