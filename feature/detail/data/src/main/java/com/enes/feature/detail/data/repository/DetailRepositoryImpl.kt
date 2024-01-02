package com.enes.feature.detail.data.repository

import com.enes.common.data.base.BaseRepository
import com.enes.common.data.dto.NetworkWrapper
import com.enes.common.data.utils.mapResponseToEntity
import com.enes.feature.detail.data.datasource.DetailDataSource
import com.enes.feature.detail.data.mapper.toEntity
import com.enes.feature.detail.domain.entity.GetCharacterDetailResponseModelEntity
import com.enes.feature.detail.domain.repository.DetailApiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(private val detailDataSource: DetailDataSource) :
    DetailApiRepository, BaseRepository() {
    override suspend fun getCharacterDetail(id: String): Flow<NetworkWrapper<GetCharacterDetailResponseModelEntity>> {
        return safeApiCall { detailDataSource.getCharacterDetail(id) }.mapResponseToEntity { it.toEntity() }
    }
}