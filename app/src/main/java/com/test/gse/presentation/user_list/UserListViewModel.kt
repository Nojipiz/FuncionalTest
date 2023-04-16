package com.test.gse.presentation.user_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.gse.common.Resource
import com.test.gse.domain.use_case.get_users.GetUsersUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class UserListViewModel(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    private val _state = mutableStateOf(UserListState())
    val state: State<UserListState> = _state

    init{
        getUsers()
    }

    private fun getUsers(){
        getUsersUseCase().onEach {result ->
           when(result) {
              is Resource.Success ->
                  _state.value = UserListState(users = result.data ?: emptyList(), isLoading = false)
               is Resource.Error ->
                   _state.value = UserListState(error = result.message ?: "Error", isLoading = false)
               is Resource.Loading ->
                   _state.value = UserListState(isLoading = true)
           }
        }.launchIn(viewModelScope)
    }

    fun localSearch(search: String){
        if(search.isBlank())
            _state.value = _state.value.copy(
                searchQuery = null,
                filteredUsers = emptyList()
            )
        else
            _state.value = _state.value.copy(
                searchQuery = search,
                filteredUsers = _state.value.users
                    .filter{
                        it.name
                            .lowercase()
                            .contains(search.lowercase())
                    }
            )
    }
}