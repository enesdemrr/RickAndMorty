package com.enes.common.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment(@LayoutRes layoutResId: Int) : Fragment(layoutResId) {

    protected abstract val binding: ViewBinding
    protected abstract val viewModel: BaseViewModel

    open fun bindUI() {}
    open fun bindViewModel() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectViewModel(viewModel)
        bindUI()
        bindViewModel()
    }

    open fun <VM : BaseViewModel> connectViewModel(vararg viewModels: VM) {
        viewModels.forEach { viewModel ->
            viewModel.indicator.observe(viewLifecycleOwner) {
            }
        }
    }
}