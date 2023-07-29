package com.tech.starbuks.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tech.starbuks.Greeting
import com.tech.starbuks.R
import com.tech.starbuks.ui.theme.LightGreyColor
import com.tech.starbuks.ui.theme.StarbuksTheme

@Composable
fun AppIconComponent(  //create a image background
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    background: Color = LightGreyColor,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .background(background, CircleShape)
            .size(46.dp)
            .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        IconComponent(icon = icon,tint = tint)

    }
}

@Composable
fun IconComponent(       //just take a icon from drawable
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified,
    modifier: Modifier = Modifier,
    size: Dp = 20.dp
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = "",
        modifier = modifier.size(size),
        tint = tint
    )
}

@Preview(showBackground = true)
@Composable
fun IconBtnPreview() {
    StarbuksTheme {
        AppIconComponent(icon = R.drawable.menu) {}

    }
}