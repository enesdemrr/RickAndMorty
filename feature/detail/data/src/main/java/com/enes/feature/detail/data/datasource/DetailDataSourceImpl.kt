package com.enes.feature.detail.data.datasource

import com.enes.feature.detail.data.api.DetailApi
import com.enes.feature.detail.data.model.GetCharacterDetailResponseModel
import retrofit2.Response
import javax.inject.Inject

class DetailDataSourceImpl @Inject constructor(
    private val detailApi: DetailApi
) : DetailDataSource {
    override suspend fun getCharacterDetail(id: String): Response<GetCharacterDetailResponseModel> {
        return detailApi.getCharacterDetail(id)
    }
}