package com.tech.starbuks.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tech.starbuks.Greeting
import com.tech.starbuks.R
import com.tech.starbuks.ui.theme.StarbuksTheme

@Composable
fun Logo_Component(
    modifier: Modifier = Modifier,
    size: Dp = 155.dp
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "",
        modifier = modifier.size(size)
    )
}

@Preview(showBackground = true)
@Composable
fun LogoPreview() {
    StarbuksTheme {
        Logo_Component()
    }
}