package com.vjypwr.myapplication

import android.app.Activity
import android.app.Application
import com.example.baseui.di.ActivityInjector
import com.vjypwr.myapplication.di.application.ApplicationComponent
import com.vjypwr.myapplication.di.application.ApplicationComponentProvider
import com.vjypwr.myapplication.di.application.ApplicationModule
import com.vjypwr.myapplication.di.application.DaggerApplicationComponent
import javax.inject.Inject

class MyApp : Application(), ApplicationComponentProvider, ActivityInjector {
    override val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    @Inject
    lateinit var activityInjector: ActivityInjector

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    override fun inject(activity: Activity) = activityInjector.inject(activity)
}