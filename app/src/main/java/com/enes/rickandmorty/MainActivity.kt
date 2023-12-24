package com.enes.rickandmorty

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.enes.common.presentation.BaseViewModel
import com.enes.common.presentation.activity.BaseActivity
import com.enes.common.presentation.utils.viewBinding
import com.enes.rickandmorty.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override val binding by viewBinding(ActivityMainBinding::inflate)
    override val viewModel: BaseViewModel
        get() = TODO("Not yet implemented")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}