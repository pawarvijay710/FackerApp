package com.vjypwr.myapplication.di.activity

import com.example.presentation.common.di.PreActivity
import com.vjypwr.myapplication.di.fragment.home.HomeFragmentComponent
import com.vjypwr.myapplication.di.fragment.user.UserFragmentComponent
import com.vjypwr.myapplication.views.MainActivity
import com.vjypwr.myapplication.views.UserManagementActivity
import dagger.Subcomponent

@PreActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    val userFragmentComponentBuilder: UserFragmentComponent.Builder
    val homeFragmentComponentBuilder: HomeFragmentComponent.Builder

    fun inject(activity: UserManagementActivity)
    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(module: ActivityModule): Builder
        fun build(): ActivityComponent
    }
}