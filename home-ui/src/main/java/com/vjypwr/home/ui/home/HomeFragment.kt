package com.vjypwr.home.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.baseui.di.FragmentInjector
import com.example.presentation.common.ViewModelFactoryProvider
import com.vjypwr.home.presentation.HomeViewModel
import com.vjypwr.common.ui.R
import com.vjypwr.home.ui.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactoryProvider<HomeViewModel>
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        (requireActivity() as FragmentInjector).inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModels()
        viewModel.callHomeScreenApi()
    }

    private fun observeViewModels() {
        viewModel.productApiSuccessful.observe(viewLifecycleOwner) {
            if (!it) {
                Toast.makeText(
                    activity,
                    getString(R.string.something_went_wrong),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        viewModel.productList.observe(viewLifecycleOwner) {
            //binding.textHome.text = it.toString()
        }

        viewModel.bookApiSuccessful.observe(viewLifecycleOwner) {
            if (!it) {
                Toast.makeText(
                    activity,
                    getString(R.string.something_went_wrong),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        viewModel.bookList.observe(viewLifecycleOwner) {
            //binding.textHome.text = it.toString()
        }

        viewModel.highLightList.observe(viewLifecycleOwner){
            binding.textHome.text = it.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}