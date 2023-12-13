package com.vjypwr.home.data.mapper

import com.vjypwr.home.data.model.response.book.BookResponse
import com.vjypwr.home.data.model.response.book.BookData
import com.vjypwr.home.domain.model.response.book.BookLocalResponse
import com.vjypwr.home.domain.model.response.book.BookDataLocal
import javax.inject.Inject

class BookApiToLocalMapper @Inject constructor() {

    fun toLocal(apiResponse: BookResponse): BookLocalResponse {
        return BookLocalResponse(
            apiResponse.code,
            getData(apiResponse.data), apiResponse.status, apiResponse.total
        )
    }

    private fun getData(dataList: List<BookData>?): List<BookDataLocal>? {
        val list = mutableListOf<BookDataLocal>()
        if (dataList != null) {
            for (data in dataList) {
                val localData = BookDataLocal(
                    data.author,
                    data.description,
                    data.genre,
                    data.id,
                    data.image,
                    data.isbn,
                    data.published,
                    data.publisher,
                    data.title
                )
                list.add(localData)
            }
        }
        return list
    }
}