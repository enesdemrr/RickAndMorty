package com.enes.feature.detail.domain.entity

data class GetCharacterDetailResponseModelEntity(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationEntity,
    val name: String,
    val origin: OriginEntity,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)