package com.enes.feature.detail.data.mapper

import com.enes.feature.detail.data.model.Origin
import com.enes.feature.detail.domain.entity.OriginEntity

fun Origin.toEntity() =
    OriginEntity(
        name = this.name,
        url = this.url
    )