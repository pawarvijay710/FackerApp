package com.vjypwr.myapplication.di.fragment.user

import com.example.presentation.common.di.PreFragment
import com.vjypwr.login.ui.LoginFragment
import dagger.Subcomponent

@PreFragment
@Subcomponent(modules = [UserFragmentModule::class])
interface UserFragmentComponent {
    fun inject(fragment: LoginFragment)

    @Subcomponent.Builder
    interface Builder {
        fun fragmentModule(module: UserFragmentModule): Builder
        fun build(): UserFragmentComponent
    }
}