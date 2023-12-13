package com.vjypwr.myapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.baseui.di.ActivityInjector
import com.example.baseui.di.FragmentInjector
import com.vjypwr.login.ui.LoginFragment
import com.vjypwr.myapplication.R
import com.vjypwr.myapplication.databinding.ActivityUserManagementBinding
import com.vjypwr.myapplication.di.activity.ActivityComponent
import com.vjypwr.myapplication.di.activity.ActivityComponentProvider
import com.vjypwr.myapplication.di.activity.ActivityModule
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class UserManagementActivity : AppCompatActivity(),
    ActivityComponentProvider,
    FragmentInjector,
    LoginFragment.Listener{

    private var _binding: ActivityUserManagementBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var activityComponentProvider: Provider<ActivityComponent.Builder>

    @Named("UserSpecificFragmentInjector")
    @Inject
    lateinit var fragmentInjector: FragmentInjector

    private lateinit var navController: NavController

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
        _binding = ActivityUserManagementBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        navController = Navigation.findNavController(this, R.id.user_nav_host_fragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun startHomeScreen() {
        navController.navigate(R.id.homeActivity)
        finish()
    }
}