package com.enes.common.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel(val application: Application) : ViewModel() {

    private val _indicator = MutableLiveData<Boolean>()
    val indicator: LiveData<Boolean> = _indicator

    protected fun showIndicator() {
        _indicator.postValue(true)
    }

    protected fun hideIndicator() {
        _indicator.postValue(false)
    }

}