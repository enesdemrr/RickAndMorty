package com.enes.feature.home.domain

import kotlinx.coroutines.flow.Flow

interface HomaApiRepository {

    suspend fun getAllCharacter(id: String)
}