package com.enes.feature.detail.data.api

import com.enes.feature.detail.data.model.GetCharacterDetailResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailApi {

    @GET("character/{id}")
    suspend fun getCharacterDetail(@Path("id") id: String): Response<GetCharacterDetailResponseModel>
}