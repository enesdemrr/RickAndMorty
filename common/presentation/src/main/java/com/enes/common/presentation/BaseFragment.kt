package com.enes.common.presentation

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment(@LayoutRes layoutResId: Int) : Fragment(layoutResId) {

    protected abstract val binding: ViewBinding
    protected abstract val viewModel: BaseViewModel

}