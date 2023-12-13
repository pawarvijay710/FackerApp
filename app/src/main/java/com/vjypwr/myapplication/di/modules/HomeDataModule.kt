package com.vjypwr.myapplication.di.modules

import com.vjypwr.home.data.api.HomeApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import javax.inject.Named

@Module
class HomeDataModule {
    @Provides
    @Reusable
    fun provideHomeApiService(
        @Named("BaseRetrofit") retrofit: Retrofit
    ): HomeApiService = retrofit.create(HomeApiService::class.java)
}