package com.enes.feature.home.data.di

import com.enes.feature.home.data.api.GetAllCharacterAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object HomeApiModule {
    @Provides
    fun providesHomeApi(retrofit: Retrofit): GetAllCharacterAPI {
        return retrofit.create(GetAllCharacterAPI::class.java)
    }

}