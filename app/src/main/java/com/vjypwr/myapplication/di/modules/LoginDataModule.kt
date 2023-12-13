package com.vjypwr.myapplication.di.modules

import com.vjypwr.login.data.api.LoginApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import javax.inject.Named

@Module
class LoginDataModule {
    @Provides
    @Reusable
    fun provideLoginApiService(
        @Named("BaseRetrofit") retrofit: Retrofit
    ): LoginApiService = retrofit.create(LoginApiService::class.java)
}