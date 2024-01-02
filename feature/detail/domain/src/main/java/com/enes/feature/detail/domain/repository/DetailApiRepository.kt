package com.enes.feature.detail.domain.repository

import com.enes.common.data.dto.NetworkWrapper
import com.enes.feature.detail.domain.entity.GetCharacterDetailResponseModelEntity
import kotlinx.coroutines.flow.Flow

interface DetailApiRepository {
    suspend fun getCharacterDetail(id: String): Flow<NetworkWrapper<GetCharacterDetailResponseModelEntity>>
}