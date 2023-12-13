package com.vjypwr.home.data.datasource

import com.example.data.common.utils.exception.ApiUnsuccessfulException
import com.example.domain.common.exception.ApiUnauthorizedException
import com.vjypwr.home.data.api.HomeApiService
import com.vjypwr.home.data.model.response.book.BookResponse
import com.vjypwr.home.data.model.response.product.ProductResponse
import java.lang.Exception
import java.net.HttpURLConnection
import javax.inject.Inject

class BookDataSource @Inject constructor(private val homeApiService: HomeApiService) {

    fun getBooks(quantity: Int?): BookResponse {
        try {
            val response = homeApiService.getBooks(quantity).execute()
            if (!response.isSuccessful) {
                when (response.code()) {
                    HttpURLConnection.HTTP_UNAUTHORIZED -> throw ApiUnauthorizedException()
                    else -> throw ApiUnsuccessfulException()
                }
            }
            return response.body() ?: throw ApiUnsuccessfulException()
        } catch (e: Exception) {
            throw ApiUnsuccessfulException()
        }
    }
}