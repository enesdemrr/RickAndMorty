package com.enes.feature.detail.data.datasource

import com.enes.feature.detail.data.model.GetCharacterDetailResponseModel
import retrofit2.Response

interface DetailDataSource {
    suspend fun getCharacterDetail(id:String): Response<GetCharacterDetailResponseModel>
}