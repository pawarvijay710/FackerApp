package com.vjypwr.myapplication.views

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.baseui.di.ActivityInjector
import com.example.baseui.di.FragmentInjector
import com.vjypwr.myapplication.R
import com.vjypwr.myapplication.databinding.ActivityMainBinding
import com.vjypwr.myapplication.di.activity.ActivityComponent
import com.vjypwr.myapplication.di.activity.ActivityComponentProvider
import com.vjypwr.myapplication.di.activity.ActivityModule
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class MainActivity : AppCompatActivity(),
    ActivityComponentProvider,
    FragmentInjector{

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var activityComponentProvider: Provider<ActivityComponent.Builder>


    @Named("HomeSpecificFragmentInjector")
    @Inject
    lateinit var fragmentInjector: FragmentInjector

    override val component: ActivityComponent by lazy {
        activityComponentProvider.get()
            .activityModule(ActivityModule(this))
            .build()
    }

    override fun inject(fragment: Fragment) {
        fragmentInjector.inject(fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ActivityInjector).inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}