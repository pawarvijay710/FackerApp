package com.vjypwr.home.presentation

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.common.UseCaseExecutor
import com.example.domain.common.model.UseCaseResult
import com.vjypwr.home.domain.model.response.highlight.HighlightItems
import com.vjypwr.home.domain.model.response.book.BookDataLocal
import com.vjypwr.home.domain.model.response.product.ProductDataLocal
import com.vjypwr.home.domain.usecase.BookUseCase
import com.vjypwr.home.domain.usecase.HighlightUseCase
import com.vjypwr.home.domain.usecase.ProductUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val useCaseExecutor: UseCaseExecutor,
    private val productUseCase: ProductUseCase,
    private val bookUseCase: BookUseCase,
    private val highlightUseCase: HighlightUseCase,
    private val resources: Resources
) : ViewModel() {
    private var highlightItems = mutableListOf<HighlightItems>()
    private val _productApiSuccessful = MutableLiveData<Boolean>()
    val productApiSuccessful: LiveData<Boolean> = _productApiSuccessful

    private val _productList = MutableLiveData<List<ProductDataLocal>>()
    val productList: LiveData<List<ProductDataLocal>> = _productList

    private val _bookApiSuccessful = MutableLiveData<Boolean>()
    val bookApiSuccessful: LiveData<Boolean> = _bookApiSuccessful

    private val _bookList = MutableLiveData<List<BookDataLocal>>()
    val bookList: LiveData<List<BookDataLocal>> = _bookList

    private val _highLightList = MutableLiveData<List<HighlightItems>>()
    val highLightList: LiveData<List<HighlightItems>> = _highLightList

    fun callHomeScreenApi() {
        callGetHighlightApi(1)
        //callGetProductsApi(10)
        //callGetBooksApi(10)

        highlightItems.sortBy { it.id }
        Log.d("MyTag", highlightItems.toString())
        _highLightList.value = highlightItems
    }

    private fun callGetHighlightApi(quantity: Int) {
        useCaseExecutor.execute(highlightUseCase, quantity) { highlightResult ->
            if (highlightResult is UseCaseResult.Success) {
                if (highlightResult.data.data?.isNotEmpty() == true) {
                    _productApiSuccessful.value = true
                    highlightItems.addAll(highlightResult.data.data!!)
                    highlightItems.sortBy { it.id }
                    Log.d("MyTag", highlightItems.toString())
                    _highLightList.value = highlightItems
                }
            } else if (highlightResult is UseCaseResult.Failure) {
                _productApiSuccessful.value = false
            }
        }
    }

    fun callGetProductsApi(quantity: Int) {
        useCaseExecutor.execute(productUseCase, quantity) { productResult ->
            if (productResult is UseCaseResult.Success) {
                if (productResult.data.code == 200) {
                    _productApiSuccessful.value = true
                    _productList.value = productResult.data.data
                }
            } else if (productResult is UseCaseResult.Failure) {
                _productApiSuccessful.value = false
            }
        }
    }

    fun callGetBooksApi(quantity: Int) {
        useCaseExecutor.execute(bookUseCase, quantity) { bookResult ->
            if (bookResult is UseCaseResult.Success) {
                if (bookResult.data.code == 200) {
                    _bookApiSuccessful.value = true
                }
            } else if (bookResult is UseCaseResult.Failure) {
                _bookApiSuccessful.value = false
            }
        }
    }
}