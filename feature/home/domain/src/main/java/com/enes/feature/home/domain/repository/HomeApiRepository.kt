package com.enes.feature.home.domain.repository

import com.enes.common.data.dto.NetworkWrapper
import com.enes.feature.home.domain.entity.GetAllCharacterResponseModelEntity
import kotlinx.coroutines.flow.Flow

interface HomeApiRepository {
    suspend fun getAllCharacter(): Flow<NetworkWrapper<GetAllCharacterResponseModelEntity>>
}