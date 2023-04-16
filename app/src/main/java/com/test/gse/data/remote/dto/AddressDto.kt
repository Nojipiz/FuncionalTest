package com.test.gse.data.remote.dto

import com.test.gse.domain.model.Address

data class AddressDto (
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoDto
)

fun AddressDto.toAddress() =
    Address(
        street = street,
        suite = suite,
        city = city,
        zipcode = zipcode,
        geo = geo.toGeo()
    )