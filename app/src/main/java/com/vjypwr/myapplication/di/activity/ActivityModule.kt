package com.vjypwr.myapplication.di.activity

import android.app.Activity
import com.example.baseui.di.FragmentInjector
import com.vjypwr.myapplication.di.fragment.home.HomeFragmentComponent
import com.vjypwr.myapplication.di.fragment.home.HomeSpecificFragmentInjector
import com.vjypwr.myapplication.di.fragment.user.UserFragmentComponent
import com.vjypwr.myapplication.di.fragment.user.UserSpecificFragmentInjector
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    subcomponents = [UserFragmentComponent::class,
        HomeFragmentComponent::class]
)
class ActivityModule(private val activity: Activity) {
    @Provides
    fun providesActivity() = activity

    @Provides
    fun provideActivityComponentProvider() = activity as ActivityComponentProvider

    @Provides
    @Named("UserSpecificFragmentInjector")
    fun provideUserSpecificFragmentInjector(activityComponentProvider: ActivityComponentProvider): FragmentInjector =
        UserSpecificFragmentInjector(activityComponentProvider)

    @Provides
    @Named("HomeSpecificFragmentInjector")
    fun provideHomeSpecificFragmentInjector(activityComponentProvider: ActivityComponentProvider): FragmentInjector =
        HomeSpecificFragmentInjector(activityComponentProvider)
}