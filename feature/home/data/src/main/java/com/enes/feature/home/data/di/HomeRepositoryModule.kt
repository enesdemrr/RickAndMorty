package com.enes.feature.home.data.di

import com.enes.feature.home.data.datasource.HomeDataSource
import com.enes.feature.home.data.repository.HomeRepositoryImpl
import com.enes.feature.home.domain.repository.HomeApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeRepositoryModule {

    @Provides
    @Singleton
    fun provideHomeRepository(homeDataSource: HomeDataSource): HomeApiRepository =
        HomeRepositoryImpl(homeDataSource)
}