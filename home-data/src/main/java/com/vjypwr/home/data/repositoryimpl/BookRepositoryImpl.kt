package com.vjypwr.home.data.repositoryimpl

import com.vjypwr.home.data.datasource.BookDataSource
import com.vjypwr.home.data.mapper.BookApiToLocalMapper
import com.vjypwr.home.domain.model.response.book.BookLocalResponse
import com.vjypwr.home.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val dataSource: BookDataSource,
    private val mapper: BookApiToLocalMapper
) : BookRepository {
    override fun getBooks(quantity: Int?): BookLocalResponse {
        return mapper.toLocal(dataSource.getBooks(quantity))
    }
}