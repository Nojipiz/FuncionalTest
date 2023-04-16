package com.test.gse.data.remote.dto

import com.test.gse.domain.model.User

data class UserDto(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressDto,
    val phone: String,
    val website: String,
    val company: CompanyDto
)

fun UserDto.toUser() =
    User(
        id = id,
        name = name,
        username = username,
        email = email,
        address = address.toAddress(),
        phone = phone,
        website = website,
        company = company.toCompany()
    )
