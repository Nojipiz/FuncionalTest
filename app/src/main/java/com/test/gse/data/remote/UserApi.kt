package com.test.gse.data.remote

import arrow.core.Either
import com.test.gse.data.remote.dto.UserDto
import retrofit2.http.GET

interface UserApi {
    @GET("/users")
    suspend fun getUsers(): Either<Throwable, List<UserDto>>
}