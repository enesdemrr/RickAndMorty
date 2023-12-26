package com.enes.feature.home.data.datasource

import com.enes.feature.home.data.api.HomeApi
import com.enes.feature.home.data.model.GetAllCharacterResponseModel
import retrofit2.Response
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(
    private val homeApi: HomeApi
): HomeDataSource {
    override suspend fun getAllCharacter(): Response<GetAllCharacterResponseModel> {
        return homeApi.getAllCharacters()
    }
}