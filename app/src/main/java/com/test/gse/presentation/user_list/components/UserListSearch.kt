package com.test.gse.presentation.user_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun UserListSearch(
    search:String,
    onSearchChange: (String) -> Unit
){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Users List!", fontWeight = FontWeight.Bold)
        TextField(
            value = search,
            onValueChange = onSearchChange,
            placeholder = {Text("Search By Name")},
            modifier = Modifier.fillMaxWidth()
        )
    }
}