package com.test.gse.data.remote.dto

import com.test.gse.domain.model.Geo

data class GeoDto (
    val lat: String,
    val lng: String
)

fun GeoDto.toGeo() = Geo(
    lat = lat,
    lng = lng
)