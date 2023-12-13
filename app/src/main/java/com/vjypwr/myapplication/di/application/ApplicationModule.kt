package com.vjypwr.myapplication.di.application

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.example.baseui.di.ActivityInjector
import com.example.domain.common.CoroutineContextProvider
import com.example.domain.common.DispatchersCoroutineContextProvider
import com.vjypwr.myapplication.di.activity.ActivityComponent
import com.vjypwr.myapplication.di.activity.SpecificActivityInjector
import com.vjypwr.myapplication.di.modules.LoginDataModule
import com.vjypwr.myapplication.di.modules.CommonDataModule
import com.vjypwr.myapplication.di.modules.CommonDomainModule
import com.vjypwr.myapplication.di.modules.HomeDataModule
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(
    subcomponents = [ActivityComponent::class],
    includes = [
        CommonDomainModule::class,
        CommonDataModule::class,
        LoginDataModule::class,
        HomeDataModule::class
    ]
)
class ApplicationModule(
    @get:Provides val application: Application
) {
    @Provides
    fun provideContext(application: Application): Context = application

    @Provides
    fun provideResources(application: Application): Resources = application.resources

    @Reusable
    @Provides
    fun provideCoroutineContextProvider(): CoroutineContextProvider =
        DispatchersCoroutineContextProvider()

    @Provides
    fun provideApplicationComponentProvider() = application as ApplicationComponentProvider

    @Reusable
    @Provides
    fun provideActivityInjector(applicationComponentProvider: ApplicationComponentProvider): ActivityInjector =
        SpecificActivityInjector(applicationComponentProvider)
}