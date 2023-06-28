package com.example.submission_compose.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landing_screen"){

        composable(route = "landing_screen"){
            LandingScreen(navController = navController)
        }

        composable(route = "main_screen"){
            MainScreen(navController = navController, mainViewModel = viewModel())
        }

        composable(
            route = "detail_screen/{username}",
            arguments = listOf(
                navArgument("username"){
                    type = NavType.StringType
                    nullable = false
                }
            )
        ){
            DetailScreen(
                username = it.arguments?.getString("username").toString(),
                detailViewModel = viewModel()
            )
        }
    }
}

@Composable
fun LandingScreen(navController: NavController){
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        Button(
            onClick = {
                navController.navigate("main_screen")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        ) {
            Text(text = "Main Screen",
                fontSize = 25.sp
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Button(
            onClick = {
                navController.navigate("detail_screen/jiddan300")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "About Me",
                fontSize = 25.sp
            )
        }
    }
}