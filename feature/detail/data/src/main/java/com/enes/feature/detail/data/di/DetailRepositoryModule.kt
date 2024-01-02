package com.enes.feature.detail.data.di

import com.enes.feature.detail.data.datasource.DetailDataSource
import com.enes.feature.detail.data.repository.DetailRepositoryImpl
import com.enes.feature.detail.domain.repository.DetailApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailRepositoryModule {

    @Provides
    @Singleton
    fun provideDetailHomeRepository(detailDataSource: DetailDataSource): DetailApiRepository =
        DetailRepositoryImpl(detailDataSource)
}