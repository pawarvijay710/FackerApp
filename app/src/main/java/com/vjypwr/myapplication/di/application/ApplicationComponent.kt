package com.vjypwr.myapplication.di.application

import android.app.Application
import com.vjypwr.myapplication.MyApp
import com.vjypwr.myapplication.di.activity.ActivityComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    val activityComponentBuilder: ActivityComponent.Builder

    fun application(): Application

    fun inject(application: MyApp)

    @Component.Builder
    interface Builder {
        fun applicationModule(applicationModule: ApplicationModule): Builder
        fun build(): ApplicationComponent
    }
}