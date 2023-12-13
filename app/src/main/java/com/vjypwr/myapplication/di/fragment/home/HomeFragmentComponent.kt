package com.vjypwr.myapplication.di.fragment.home

import com.example.presentation.common.di.PreFragment
import com.vjypwr.home.ui.dashboard.DashboardFragment
import com.vjypwr.home.ui.home.HomeFragment
import com.vjypwr.home.ui.notifications.NotificationsFragment
import dagger.Subcomponent

@PreFragment
@Subcomponent(modules = [HomeFragmentModule::class])
interface HomeFragmentComponent {
    fun inject(fragment: DashboardFragment)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: NotificationsFragment)

    @Subcomponent.Builder
    interface Builder {
        fun fragmentModule(module: HomeFragmentModule): Builder
        fun build(): HomeFragmentComponent
    }
}