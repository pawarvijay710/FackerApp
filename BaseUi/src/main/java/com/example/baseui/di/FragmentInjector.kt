package com.example.baseui.di

import androidx.fragment.app.Fragment

interface FragmentInjector {
    fun inject(fragment: Fragment)
}