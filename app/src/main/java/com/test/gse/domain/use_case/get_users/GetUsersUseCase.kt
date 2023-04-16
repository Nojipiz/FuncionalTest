package com.test.gse.domain.use_case.get_users

import arrow.core.Either
import com.test.gse.common.Resource
import com.test.gse.common.getMessage
import com.test.gse.data.remote.dto.toUser
import com.test.gse.domain.model.User
import com.test.gse.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUsersUseCase(
    private val repository: UserRepository
){
    operator fun invoke():Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading())
        emit (
            when (val result = repository.getUsers()){
                is Either.Left ->
                    Resource.Error(result.leftOrNull().getMessage())
                is Either.Right ->
                    Resource.Success(result.value.map{it.toUser()})
            }
        )
    }
}