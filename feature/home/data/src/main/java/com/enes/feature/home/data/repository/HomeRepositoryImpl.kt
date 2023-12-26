package com.enes.feature.home.data.repository

import com.enes.common.data.base.BaseRepository
import com.enes.common.data.dto.NetworkWrapper
import com.enes.common.data.utils.mapResponseToEntity
import com.enes.feature.home.data.datasource.HomeDataSource
import com.enes.feature.home.data.mapper.getAllCharacterToEntity
import com.enes.feature.home.domain.entity.GetAllCharacterResponseModelEntity
import com.enes.feature.home.domain.repository.HomeApiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeDataSource: HomeDataSource) :
    HomeApiRepository,
    BaseRepository() {
    override suspend fun getAllCharacter(): Flow<NetworkWrapper<GetAllCharacterResponseModelEntity>> {

        return safeApiCall { homeDataSource.getAllCharacter() }.mapResponseToEntity { it.getAllCharacterToEntity() }
    }

}