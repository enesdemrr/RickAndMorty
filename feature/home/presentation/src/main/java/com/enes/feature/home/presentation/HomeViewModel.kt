package com.enes.feature.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enes.common.data.utils.onSuccess
import com.enes.feature.home.domain.entity.ResultEntity
import com.enes.feature.home.domain.usecase.GetAllCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetAllCharacterUseCase
) : ViewModel() {

    private val _characterList = MutableLiveData<List<ResultEntity>>()
    val characterList: LiveData<List<ResultEntity>> = _characterList

    fun getAllCharacter() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.invoke()
                .collect { result ->
                    val list: ArrayList<ResultEntity> = arrayListOf()
                    result.onSuccess { success ->
                        success.data.results?.let { nullableList ->
                            nullableList.forEach { item ->
                                item?.let {
                                    list.add(it)
                                }
                            }
                        }
                        _characterList.postValue(list)
                    }
                }
        }
    }

}