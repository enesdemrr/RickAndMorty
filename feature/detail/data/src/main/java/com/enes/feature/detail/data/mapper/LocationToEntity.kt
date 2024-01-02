package com.enes.feature.detail.data.mapper

import com.enes.feature.detail.data.model.Location
import com.enes.feature.detail.domain.entity.LocationEntity

fun Location.toEntity() =
    LocationEntity(
        name = this.name,
        url = this.url
    )