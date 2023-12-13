package com.example.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactoryProvider<V>(private val viewModel: V) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalArgumentException::class)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isInstance(viewModel)) viewModel as T
        else throw IllegalArgumentException("ViewModel not provided")
    }

}