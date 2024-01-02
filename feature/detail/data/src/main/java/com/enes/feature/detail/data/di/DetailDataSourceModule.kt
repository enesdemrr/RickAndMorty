package com.enes.feature.detail.data.di

import com.enes.feature.detail.data.datasource.DetailDataSource
import com.enes.feature.detail.data.datasource.DetailDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DetailDataSourceModule {
    @Binds
    @Singleton
    fun provideDetailDataSourceModule(dataSourceImpl: DetailDataSourceImpl): DetailDataSource
}