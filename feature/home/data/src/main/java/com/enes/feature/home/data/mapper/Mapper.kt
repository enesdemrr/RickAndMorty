package com.enes.feature.home.data.mapper

import com.enes.feature.home.data.model.GetAllCharacterResponseModel
import com.enes.feature.home.data.model.Info
import com.enes.feature.home.data.model.Location
import com.enes.feature.home.data.model.Origin
import com.enes.feature.home.data.model.Result
import com.enes.feature.home.domain.entity.GetAllCharacterResponseModelEntity
import com.enes.feature.home.domain.entity.InfoEntity
import com.enes.feature.home.domain.entity.LocationEntity
import com.enes.feature.home.domain.entity.OriginEntity
import com.enes.feature.home.domain.entity.ResultEntity

fun GetAllCharacterResponseModel.getAllCharacterToEntity() = GetAllCharacterResponseModelEntity(
    info = this.info?.infoToEntity(),
    results = this.results.resultToResultEntity()
)

fun Info.infoToEntity() = InfoEntity(
    count = this.count,
    next = this.next,
    pages = this.pages,
    prev = this.prev
)

fun Result.resultToResultEntity() = ResultEntity(
    created = this.created,
    episode = this.episode,
    gender = this.gender,
    id = this.id,
    image = this.image,
    location = this.location?.locationToLocationEntity(),
    name = this.name,
    origin = this.origin?.originToEntity(),
    species = this.species,
    status = this.status,
    type = this.type,
    url = this.url
)

fun Location.locationToLocationEntity() = LocationEntity(
    name = this.name,
    url = this.url
)

fun Origin.originToEntity() = OriginEntity(
    name = this.name,
    url = this.url
)

fun List<Result?>?.resultToResultEntity()=this?.map{
    it?.resultToResultEntity()
}