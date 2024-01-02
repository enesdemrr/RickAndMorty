package com.enes.feature.detail.data.di

import com.enes.feature.detail.data.api.DetailApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailApiModule {
    @Singleton
    @Provides
    fun providesDetailApi(
        retrofit: Retrofit
    ): DetailApi = retrofit.create(DetailApi::class.java)
}