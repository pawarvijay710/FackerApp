package com.vjypwr.myapplication.di.fragment.home

import androidx.fragment.app.Fragment
import com.example.presentation.common.ViewModelFactoryProvider
import com.vjypwr.home.data.repositoryimpl.BookRepositoryImpl
import com.vjypwr.home.data.repositoryimpl.ProductRepositoryImpl
import com.vjypwr.home.domain.repository.BookRepository
import com.vjypwr.home.domain.repository.ProductRepository
import com.vjypwr.home.presentation.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule(val fragment: Fragment) {
    @Provides
    fun provideFragment() = fragment

    @Provides
    fun provideHomeViewModelFactory(viewModel: HomeViewModel): ViewModelFactoryProvider<HomeViewModel> =
        ViewModelFactoryProvider(viewModel)

    @Provides
    fun providesProductRepositoryImpl(repository: ProductRepositoryImpl): ProductRepository =
        repository

    @Provides
    fun providesBookRepositoryImpl(repository: BookRepositoryImpl): BookRepository =
        repository
}