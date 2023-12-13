package com.vjypwr.myapplication.di.modules

import com.example.data.common.intercepters.MetaHeaderInterceptor
import com.example.data.common.utils.InterceptorContainer
import com.vjypwr.myapplication.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class CommonDataModule {


    @Reusable
    @Provides
    fun provideHttpLoginInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Reusable
    @Provides
    @Named("OkHttpInterceptor")
    fun provideInterceptors(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        metaHeaderInterceptor: MetaHeaderInterceptor
    ): InterceptorContainer {
        return InterceptorContainer(
            listOf(
                httpLoggingInterceptor,
                metaHeaderInterceptor
            )
        )
    }

    @Reusable
    @Provides
    fun provideOkHttpClient(
        @Named("OkHttpInterceptor") interceptorContainer: InterceptorContainer
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
        interceptorContainer.interceptor.forEach { interpolator ->
            okHttpClientBuilder.addInterceptor(interpolator)
        }
        return okHttpClientBuilder.build()
    }

    @Reusable
    @Provides
    fun getGsonConverterFactor(): GsonConverterFactory = GsonConverterFactory.create()

    @Reusable
    @Provides
    @Named("BaseRetrofit")
    fun getBaseRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}