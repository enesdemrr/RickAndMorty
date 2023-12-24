package com.enes.common.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.enes.common.presentation.BaseViewModel

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val binding: ViewBinding
    protected abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}