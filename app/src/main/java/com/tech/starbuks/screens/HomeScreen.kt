package com.tech.starbuks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tech.starbuks.R
import com.tech.starbuks.components.AppIconComponent
import com.tech.starbuks.components.IconComponent
import com.tech.starbuks.components.Logo_Component
import com.tech.starbuks.data.Menu
import com.tech.starbuks.data.menuList
import com.tech.starbuks.navigation.product_detail
import com.tech.starbuks.ui.theme.BackgroundColor
import com.tech.starbuks.ui.theme.DarkGrayColor
import com.tech.starbuks.ui.theme.DarkGreenColor
import com.tech.starbuks.ui.theme.GrayColor
import com.tech.starbuks.ui.theme.LightWhiteColor
import com.tech.starbuks.ui.theme.RedColor
import com.tech.starbuks.ui.theme.StarbuksTheme
import com.tech.starbuks.ui.theme.TextColor

@Composable
fun HomeScreen(navHostController: NavHostController) {

    var search by remember {
        mutableStateOf("")
    }
    var selected by remember {
        mutableStateOf(1)
    }
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

            Header()

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    TextDescription()
                    Box {
                        SearchBar(text = search, onValueChange = {
                            search = it
                        })
                        AppIconComponent(
                            icon = R.drawable.filter,
                            background = DarkGreenColor,
                            modifier = Modifier
                                .align(
                                    Alignment.TopEnd
                                )
                                .size(55.dp)
                        )
                    }
                    LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
                        items(menuList, key = { it.id }) {
                            CustomChipScreen(
                                menu = it,
                                selected = it.id == selected,
                                onValueChange = { id ->
                                    selected = id
                                })
                        }

                    }
                    Popular {
                        navHostController.navigate(product_detail)
                    }
                }
            }
        }
    }
}

@Composable
private fun Popular(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(R.string.popular), style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W500,
                    color = TextColor
                )
            )
            Text(
                text = stringResource(R.string.see_all), style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W500,
                    color = DarkGreenColor,
                )
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        LazyRow {
            items(5) {
                ItemEachRow {
                    onClick()
                }
            }
        }
    }
}

@Composable
private fun ItemEachRow(onClick: () -> Unit) {

    var favSelected by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .width(220.dp)
            .padding(end = 10.dp)
            .clickable { onClick() }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(
                        color = LightWhiteColor,
                        RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
                    )
                    .fillMaxWidth()
                    .height(200.dp), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "",
                    modifier = Modifier.size(180.dp)
                )
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = stringResource(R.string.chocolate_cappuccino), style = TextStyle(
                        color = DarkGrayColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$20.00", style = TextStyle(
                            color = DarkGreenColor,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W400
                        )
                    )
                    IconButton(onClick = { favSelected = !favSelected }) {
                        IconComponent(
                            icon = R.drawable.love,
                            tint = if (favSelected) RedColor else Color.Unspecified
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CustomChipScreen(
    menu: Menu,
    selected: Boolean,
    onValueChange: (Int) -> Unit
) {
    TextButton(
        onClick = {
            onValueChange(menu.id)
        }, shape = RoundedCornerShape(22.dp), colors = ButtonDefaults.textButtonColors(
            containerColor = if (selected) DarkGreenColor else GrayColor,
            contentColor = if (selected) Color.White else TextColor
        ), contentPadding = PaddingValues(15.dp), modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = menu.title, style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W400
            )
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchBar(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = stringResource(R.string.search),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    color = DarkGrayColor
                )
            )
        },
        leadingIcon = {
            IconComponent(icon = R.drawable.search)
        },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.5.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = DarkGreenColor
        )
    )
}

@Composable
private fun TextDescription() {
    Text(
        text = stringResource(R.string.our_way_of_loving_you_back), style = TextStyle(
            fontSize = 25.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black
        ), modifier = Modifier.padding(vertical = 30.dp)
    )
}

@Composable
private fun Header() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        AppIconComponent(icon = R.drawable.menu)
        Logo_Component(size = 58.dp)
        AppIconComponent(icon = R.drawable.bag)
    }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {

    val navHostController = rememberNavController()
    StarbuksTheme {
        HomeScreen(navHostController = navHostController)
//        CustomChipScreen(menu = menuList[0], selected = true, onValueChange = {})
//        ItemEachRow {
//
//        }
    }
}