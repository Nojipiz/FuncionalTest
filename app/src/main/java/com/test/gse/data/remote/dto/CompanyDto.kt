package com.test.gse.data.remote.dto

import com.test.gse.domain.model.Company

data class CompanyDto (
    val name: String,
    val catchPhrase: String,
    val bs: String
)

fun CompanyDto.toCompany() =
    Company(
        name = name,
        catchPhrase = catchPhrase,
        bs = bs
    )