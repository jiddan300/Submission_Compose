package com.example.submission_compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.submission_compose.api.ItemsItem

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel){

    mainViewModel.getListUser("arif")
    val list = mainViewModel.listUser
    LazyColumn{
        itemsIndexed(items = list){ index, item ->
            UserItem(item, navController)
        }
    }
}

@Composable
fun UserItem(user: ItemsItem, navController: NavController){
    Card(
        modifier = Modifier
            .clickable {
                navController.navigate("detail_screen/${user.login}")
            }
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Surface {
            Row (
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ){
                AsyncImage(
                    model = user.avatarUrl,
                    contentDescription = user.login,

                    modifier = Modifier
                        .clip(CircleShape)
                        .size(100.dp)
                )

                Text(
                    text = user.login,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(10.dp)
                )
            }
        }
    }
}