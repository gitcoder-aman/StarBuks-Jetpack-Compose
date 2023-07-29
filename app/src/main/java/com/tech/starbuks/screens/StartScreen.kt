package com.tech.starbuks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tech.starbuks.components.Logo_Component
import com.tech.starbuks.navigation.home
import com.tech.starbuks.ui.theme.BackgroundColor
import com.tech.starbuks.ui.theme.StarbuksTheme
import kotlinx.coroutines.delay

@Composable
fun StartScreen(navHostController: NavHostController) {

    LaunchedEffect(key1 = Unit, block = {  //navigate to home screen after 2 sec
        delay(2000)
        navHostController.navigate(home)
    })
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor), contentAlignment = Alignment.Center
    ) {
        Logo_Component()
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StarbuksTheme {
        val navHostController = rememberNavController()
        StartScreen(navHostController = navHostController)
    }
}