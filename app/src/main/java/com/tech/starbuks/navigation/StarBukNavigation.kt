package com.tech.starbuks.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tech.starbuks.screens.HomeScreen
import com.tech.starbuks.screens.ProductDetail
import com.tech.starbuks.screens.StartScreen

@Composable
fun StarBukNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = start ){
        composable(start){
            StartScreen(navHostController = navHostController )
        }
        composable(home){
            HomeScreen(navHostController = navHostController )
        }
        composable(product_detail){
            ProductDetail(navHostController = navHostController )
        }
    }


    
}

const val start = "start_screen"
const val home = "home_screen"
const val product_detail = "product_detail"