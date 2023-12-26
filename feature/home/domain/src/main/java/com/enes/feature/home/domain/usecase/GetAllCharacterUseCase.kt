package com.enes.feature.home.domain.usecase

import com.enes.feature.home.domain.repository.HomeApiRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(
    private val homeApiRepository: HomeApiRepository
) {
    suspend fun invoke() = homeApiRepository.getAllCharacter()
}