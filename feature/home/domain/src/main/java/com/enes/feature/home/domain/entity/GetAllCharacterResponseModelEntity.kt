package com.enes.feature.home.domain.entity

data class GetAllCharacterResponseModelEntity(
    var info: InfoEntity?,
    var results: List<ResultEntity?>?
)

data class InfoEntity(
    var count: Int?,
    var next: String?,
    var pages: Int?,
    var prev: String?
)

data class ResultEntity(
    var created: String?,
    var episode: List<String?>?,
    var gender: String?,
    var id: Int?,
    var image: String?,
    var location: LocationEntity?,
    var name: String?,
    var origin: OriginEntity?,
    var species: String?,
    var status: String?,
    var type: String?,
    var url: String?
)

data class LocationEntity(
    var name: String?,
    var url: String?
)

data class OriginEntity(
    var name: String?,
    var url: String?
)