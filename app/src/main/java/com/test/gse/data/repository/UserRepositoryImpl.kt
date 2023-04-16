package com.test.gse.data.repository

import arrow.core.Either
import com.test.gse.common.Problem
import com.test.gse.data.remote.UserApi
import com.test.gse.data.remote.dto.UserDto
import com.test.gse.domain.repository.UserRepository

class UserRepositoryImpl(
    private val api: UserApi
): UserRepository {

    override suspend fun getUsers(): Either<Problem, List<UserDto>> =
        api.getUsers()
            .mapLeft {
                Problem.ConnectionError(throwable = it)
            }
}
