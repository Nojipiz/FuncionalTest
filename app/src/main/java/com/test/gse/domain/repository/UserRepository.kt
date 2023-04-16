package com.test.gse.domain.repository

import arrow.core.Either
import com.test.gse.common.Problem
import com.test.gse.data.remote.dto.UserDto

interface UserRepository {
    suspend fun getUsers(): Either<Problem, List<UserDto>>
}