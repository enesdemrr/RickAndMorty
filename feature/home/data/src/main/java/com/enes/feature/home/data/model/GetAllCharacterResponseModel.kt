package com.enes.feature.home.data.model

data class GetAllCharacterResponseModel(
    var info: Info?,
    var results: List<Result?>?
)

data class Info(
    var count: Int?,
    var next: String?,
    var pages: Int?,
    var prev: String?
)

data class Result(
    var created: String?,
    var episode: List<String?>?,
    var gender: String?,
    var id: Int?,
    var image: String?,
    var location: Location?,
    var name: String?,
    var origin: Origin?,
    var species: String?,
    var status: String?,
    var type: String?,
    var url: String?
) {
    data class Location(
        var name: String?,
        var url: String?
    )

    data class Origin(
        var name: String?,
        var url: String?
    )
}
