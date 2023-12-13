package com.vjypwr.home.data.api

import com.vjypwr.home.data.model.response.book.BookResponse
import com.vjypwr.home.data.model.response.product.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApiService {
    @GET("v1/products")
    fun getProducts(@Query("_quantity") quantity: Int?): Call<ProductResponse>

    @GET("v1/books")
    fun getBooks(@Query("_quantity") quantity: Int?): Call<BookResponse>
}