package com.enes.feature.home.data.datasource

import com.enes.feature.home.data.model.GetAllCharacterResponseModel
import retrofit2.Response

interface HomeDataSource {
    suspend fun getAllCharacter(): Response<GetAllCharacterResponseModel>
}