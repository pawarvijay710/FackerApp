package com.vjypwr.login.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.baseui.di.FragmentInjector
import com.vjypwr.common.ui.R
import com.example.login.ui.databinding.FragmentLoginBinding
import com.example.presentation.common.AccountDTO
import com.example.presentation.common.ViewModelFactoryProvider
import com.vjypwr.login.presentation.LoginViewModel
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactoryProvider<LoginViewModel>

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]
    }

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        (requireActivity() as FragmentInjector).inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModels()

        binding.loginButton.setOnClickListener {
            binding.password.error = ""
            binding.username.error = ""
            viewModel.validate(binding.username.text.toString(), binding.password.text.toString())
        }
    }

    private fun observeViewModels() {
        viewModel.isValidInput.observe(viewLifecycleOwner) { isValidInput ->
            if (isValidInput) {
                viewModel.callUserLoginApi(
                    binding.username.text.toString(),
                    binding.password.text.toString()
                )
            } else {
                binding.password.error = getString(R.string.invalid_username_password)
            }
        }

        viewModel.loginMessage.observe(viewLifecycleOwner) { loginMessage ->
            Toast.makeText(activity, loginMessage, Toast.LENGTH_SHORT).show()
        }

        viewModel.loginSuccessful.observe(viewLifecycleOwner) { isLoginSuccessful ->
            if (isLoginSuccessful) {
                AccountDTO.userName = binding.username.text.toString()
                (activity as Listener).startHomeScreen()
            } else {
                Toast.makeText(activity, "Can not proceed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    interface Listener {
        fun startHomeScreen()
    }
}