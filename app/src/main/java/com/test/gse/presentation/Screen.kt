package com.test.gse.presentation

sealed class Screen(val route: String) {
    object UserList:Screen("users_list")
}