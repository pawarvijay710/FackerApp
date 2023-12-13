package com.example.baseui.di

import android.app.Activity

interface ActivityInjector {
    fun inject(activity: Activity)
}