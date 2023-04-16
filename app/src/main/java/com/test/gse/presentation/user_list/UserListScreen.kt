package com.test.gse.presentation.user_list

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.test.gse.presentation.user_list.components.UserListItem
import com.test.gse.presentation.user_list.components.UserListSearch
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserListScreen(
    viewModel:UserListViewModel = koinViewModel()
){
    val state = viewModel.state.value
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        UserListSearch(state.searchQuery ?: "") { viewModel.localSearch(it) }
        if(state.isLoading){
            CircularProgressIndicator()
        }
        if(state.error != null){
            Text(text = state.error)
        }
        val users = if(state.searchQuery != null)
            state.filteredUsers
        else
            state.users
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(users) {user ->
                UserListItem(
                    user = user,
                    onItemClick = {
                        Toast.makeText(
                            context,
                            "User: ${it.name}",
                            Toast.LENGTH_LONG).show()
                    }
                )
            }
        }
    }
}