package com.test.gse.presentation.user_list

import com.test.gse.domain.model.User

data class UserListState (
    val isLoading:Boolean = false,
    val users: List<User> = emptyList(),
    val searchQuery: String? = null,
    val filteredUsers: List<User> = emptyList(),
    val error:String? = null
)