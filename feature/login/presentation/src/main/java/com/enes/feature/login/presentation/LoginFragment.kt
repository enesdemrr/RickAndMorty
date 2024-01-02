package com.enes.feature.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.enes.common.presentation.BaseFragment
import com.enes.feature.login.presentation.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    override val binding get() = _binding!!
    override val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()

    }

    override fun bindUI() {
        binding.apply {
            button.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            }
        }
    }
}