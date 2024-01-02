package com.enes.feature.home.presentation

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.enes.common.presentation.BaseFragment
import com.enes.common.presentation.utils.fragmentViewBinding
import com.enes.feature.home.presentation.adapter.HomeAdapter
import com.enes.feature.home.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment(R.layout.fragment_home) {
    override val binding by fragmentViewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()


    override fun bindUI() {
        val adapter = HomeAdapter()
        viewModel.characterList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        binding.recyclerView.adapter = adapter
        adapter.setItemClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    it.id.toString()
                )
            )
        }
    }

    override fun bindViewModel() {
        viewModel.getAllCharacter()
    }
}