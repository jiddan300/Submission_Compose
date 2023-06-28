package com.example.submission_compose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun DetailScreen(username : String, detailViewModel: DetailViewModel){
    detailViewModel.getDetailUser(username)

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
    ){
        AsyncImage(
            model = detailViewModel.avatarUser,
            contentDescription = detailViewModel.namaUser,

            modifier = Modifier
                .align(CenterHorizontally)
                .clip(CircleShape)
                .size(200.dp)
        )

        Spacer(modifier = Modifier.size(10.dp))

        Text(
            text = detailViewModel.namaUser,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = detailViewModel.idUser,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}
