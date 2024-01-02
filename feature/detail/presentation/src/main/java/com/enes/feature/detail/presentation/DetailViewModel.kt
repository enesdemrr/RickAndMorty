package com.enes.feature.detail.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.enes.common.data.utils.onError
import com.enes.common.data.utils.onSuccess
import com.enes.common.presentation.BaseViewModel
import com.enes.feature.detail.domain.entity.GetCharacterDetailResponseModelEntity
import com.enes.feature.detail.domain.usecase.GetCharacterDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    application: Application,
    private val useCase: GetCharacterDetailUseCase
) : BaseViewModel(application) {

    private val _characterDetail = MutableLiveData<GetCharacterDetailResponseModelEntity>()
    val characterDetail: LiveData<GetCharacterDetailResponseModelEntity> = _characterDetail

    fun getCharacterDetail(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.invoke(id)
                .onStart { }
                .onCompletion {  }
                .collect { result ->
                    result.onSuccess { success ->
                        _characterDetail.postValue((success.data))
                    }
                    result.onError {
                    }
                }
        }
    }
}