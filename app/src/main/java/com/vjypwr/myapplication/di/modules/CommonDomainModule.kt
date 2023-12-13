package com.vjypwr.myapplication.di.modules

import com.example.domain.common.JobProvider
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.coroutines.Job

@Module
class CommonDomainModule {
    @Reusable
    @Provides
    fun provideJobProvider(): JobProvider = object : JobProvider {
        override fun invoke() = Job()
    }
}