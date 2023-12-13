package com.vjypwr.myapplication.di.fragment.user

import androidx.fragment.app.Fragment
import com.example.baseui.di.FragmentInjector
import com.vjypwr.login.ui.LoginFragment
import com.vjypwr.myapplication.di.activity.ActivityComponentProvider

class UserSpecificFragmentInjector(private val activityComponentProvider: ActivityComponentProvider) :
    FragmentInjector {
    override fun inject(fragment: Fragment) {
        when (fragment) {
            is LoginFragment -> fragment.getComponent().inject(fragment)

        }
    }

    private fun Fragment.getComponent() = activityComponentProvider
        .component.userFragmentComponentBuilder
        .fragmentModule(UserFragmentModule(this))
        .build()
}