package com.tech.starbuks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tech.starbuks.R
import com.tech.starbuks.components.AppIconComponent
import com.tech.starbuks.components.IconComponent
import com.tech.starbuks.components.Logo_Component
import com.tech.starbuks.ui.theme.BackgroundColor
import com.tech.starbuks.ui.theme.DarkGreenColor
import com.tech.starbuks.ui.theme.Gray500Color
import com.tech.starbuks.ui.theme.GrayColor
import com.tech.starbuks.ui.theme.LightWhiteColor
import com.tech.starbuks.ui.theme.StarbuksTheme
import com.tech.starbuks.ui.theme.TextColor

@Composable
fun ProductDetail(navHostController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            ProductHeader(onClick = {
                navHostController.navigateUp()
            })
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    ShowProduct()
                    ProductDescription()
                }
            }
        }
        ButtonComponent(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        )
    }

}

@Composable
private fun ShowProduct() {

    var counter by remember {
        mutableStateOf(0)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightWhiteColor, RoundedCornerShape(14.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "",
                modifier = Modifier
                    .size(200.dp)
                    .align(CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .align(CenterHorizontally)
            ) {
                Row {
                    AppIconComponent(
                        icon = R.drawable.plus, tint = Color.White, background = DarkGreenColor
                    ) {
                        counter++
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = counter.toString(), style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.W500,
                            color = TextColor
                        ), modifier = Modifier.align(CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    AppIconComponent(
                        icon = R.drawable.minus,
                        tint = Color.White,
                        background = DarkGreenColor
                    ) {
                        if (counter > 0)
                            counter--;
                    }
                }
            }

        }
    }
}

@Composable
fun ProductDescription() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {

        Text(
            text = stringResource(R.string.coffee), style = TextStyle(
                fontSize = 18.sp,
                color = DarkGreenColor,
                fontWeight = FontWeight.W400
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Chocolate Cappuccino", style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W500
                ),modifier = Modifier.weight(0.8f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterVertically).weight(0.2f)
            ) {
                IconComponent(
                    icon = R.drawable.star,
                    size = 20.dp,
                    modifier = Modifier
                        .align(CenterVertically), tint = Color.Yellow
                )
                Text(
                    text = "4.5", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        color = TextColor
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = stringResource(R.string.lorem_sentence), style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                color = TextColor
            )
        )
    }
}

@Composable
private fun ButtonComponent(modifier: Modifier = Modifier) {
    Button(
        onClick = {}, modifier = modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = DarkGreenColor,
        ), shape = RoundedCornerShape(37.dp),
        contentPadding = PaddingValues(vertical = 15.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {
        Text(
            text = "Add to Bag", style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            )
        )
    }
}

@Composable
private fun ProductHeader(onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        AppIconComponent(icon = R.drawable.back) {
            onClick()
        }
        Logo_Component(size = 55.dp)
        AppIconComponent(icon = R.drawable.love)
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {

//    val navHostController = rememberNavController()
//    StarbuksTheme {
//        ProductDetail(navHostController = navHostController)
//    }
}