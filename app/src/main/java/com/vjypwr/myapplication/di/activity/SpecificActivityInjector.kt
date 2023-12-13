package com.vjypwr.myapplication.di.activity

import android.app.Activity
import com.example.baseui.di.ActivityInjector
import com.vjypwr.myapplication.di.application.ApplicationComponentProvider
import com.vjypwr.myapplication.views.MainActivity
import com.vjypwr.myapplication.views.UserManagementActivity

class SpecificActivityInjector(
    private val applicationComponentProvider: ApplicationComponentProvider
) : ActivityInjector {
    override fun inject(activity: Activity) = when (activity) {
        is UserManagementActivity -> activity.getComponent().inject(activity)
        is MainActivity -> activity.getComponent().inject(activity)
        else -> throw IllegalArgumentException("Unknown Activity $activity")
    }

    private fun Activity.getComponent() =
        applicationComponentProvider.component
            .activityComponentBuilder
            .activityModule(ActivityModule(this))
            .build()

}