package com.enes.feature.login.presentation

import android.app.Application
import com.enes.common.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject
constructor(application: Application): BaseViewModel(application) {
}