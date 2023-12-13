package com.vjypwr.myapplication.di.fragment.home

import androidx.fragment.app.Fragment
import com.example.baseui.di.FragmentInjector
import com.vjypwr.home.ui.home.HomeFragment
import com.vjypwr.myapplication.di.activity.ActivityComponentProvider

class HomeSpecificFragmentInjector(private val activityComponentProvider: ActivityComponentProvider) :
    FragmentInjector {
    override fun inject(fragment: Fragment) {
        when (fragment) {
            is HomeFragment -> fragment.getComponent().inject(fragment)

        }
    }

    private fun Fragment.getComponent() = activityComponentProvider
        .component.homeFragmentComponentBuilder
        .fragmentModule(HomeFragmentModule(this))
        .build()
}