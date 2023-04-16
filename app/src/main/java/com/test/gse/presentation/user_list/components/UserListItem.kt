package com.test.gse.presentation.user_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.test.gse.domain.model.User

@Composable
fun UserListItem(
   user: User,
   onItemClick: (User) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(user) }
            .padding(10.dp),
    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color.Gray)
        )
        Row{
            Column {
                UserProperty(title = "Name", data = user.name )
                UserProperty(title = "User Name", data = user.username)
            }
            Column {
                UserProperty(title = "Email", data = user.email)
                UserProperty(title = "Phone", data = user.phone)
            }
        }
        UserProperty(title = "Website", data = user.website)
    }
}

@Composable
private fun UserProperty(title:String, data:String){
    Column(modifier= Modifier.padding(10.dp)) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
        Text(text = data)
    }
}
