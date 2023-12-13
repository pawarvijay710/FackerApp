package com.vjypwr.myapplication.di.fragment.user

import androidx.fragment.app.Fragment
import com.example.presentation.common.ViewModelFactoryProvider
import com.vjypwr.login.data.repositoryimpl.LoginRepositoryImpl
import com.vjypwr.login.domain.repository.LoginRepository
import com.vjypwr.login.presentation.LoginViewModel
import dagger.Module
import dagger.Provides

@Module
class UserFragmentModule(private val fragment: Fragment) {
    @Provides
    fun provideFragment() = fragment

    @Provides
    fun provideLoginViewModelFactory(viewModel: LoginViewModel): ViewModelFactoryProvider<LoginViewModel> =
        ViewModelFactoryProvider(viewModel)

    @Provides
    fun providesLoginRepositoryImpl(repository: LoginRepositoryImpl): LoginRepository =
        repository
}