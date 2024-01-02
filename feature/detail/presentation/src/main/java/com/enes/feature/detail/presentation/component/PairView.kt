package com.enes.feature.detail.presentation.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.enes.feature.detail.presentation.databinding.ItemDetailBinding

class PairView @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, attr: Int = 0
) : FrameLayout(context, attributeSet, attr) {

    private val binding: ItemDetailBinding = ItemDetailBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    fun setUp(key: String, value: String) {
        binding.key.text = key
        binding.value.text = value
    }

}