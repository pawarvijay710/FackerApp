package com.vjypwr.home.domain.usecase

import com.example.domain.common.BackGroundExecuteUseCase
import com.example.domain.common.CoroutineContextProvider
import com.vjypwr.home.domain.model.response.book.BookDataLocal
import com.vjypwr.home.domain.model.response.highlight.HighlightItems
import com.vjypwr.home.domain.model.response.highlight.HighlightLocalResponse
import com.vjypwr.home.domain.model.response.product.ProductDataLocal
import com.vjypwr.home.domain.repository.BookRepository
import com.vjypwr.home.domain.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HighlightUseCase @Inject constructor(
    coroutineContextProvider: CoroutineContextProvider,
    private val bookRepository: BookRepository,
    private val productRepository: ProductRepository
) : BackGroundExecuteUseCase<Int, HighlightLocalResponse>(coroutineContextProvider) {
    private var highlightItems = mutableListOf<HighlightItems>()
    override suspend fun executeInBackground(
        value: Int, coroutineScope: CoroutineScope
    ): HighlightLocalResponse {
        val bookLocal = bookRepository.getBooks(value)
        processBookData(bookLocal.data)
        val productLocal = productRepository.getProducts(value)
        processProductData(productLocal.data)
        return HighlightLocalResponse(highlightItems)
    }

    private fun processProductData(productList: List<ProductDataLocal>?) {
        if (productList != null) {
            for (product in productList) {
                val item = HighlightItems(
                    product.id,
                    product.name,
                    product.image,
                    product.description,
                    "product"
                )
                highlightItems.add(item)
            }
        }
    }

    private fun processBookData(bookList: List<BookDataLocal>?) {
        if (bookList != null) {
            for (book in bookList) {
                val item = HighlightItems(
                    book.id,
                    book.title,
                    book.image,
                    book.description,
                    "book"
                )
                highlightItems.add(item)
            }
        }
    }
}