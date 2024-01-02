package com.enes.feature.detail.data.mapper

import com.enes.feature.detail.data.model.GetCharacterDetailResponseModel
import com.enes.feature.detail.domain.entity.GetCharacterDetailResponseModelEntity

fun GetCharacterDetailResponseModel.toEntity() =
    GetCharacterDetailResponseModelEntity(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        origin = this.origin.toEntity(),
        location = this.location.toEntity(),
        image = this.image,
        episode = this.episode,
        url = this.url,
        created = this.created
    )