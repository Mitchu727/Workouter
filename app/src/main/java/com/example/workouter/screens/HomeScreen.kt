package com.example.workouter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workouter.ui.theme.Burgundy

@Preview
@Composable
fun HomeScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Burgundy)) {
            HomeScreenButton(onClick = { /*TODO*/ }, text = "Start \nTraining")
            HomeScreenButton(onClick = { /*TODO*/ }, text = "Activities")
            HomeScreenButton(onClick = { /*TODO*/ }, text = "Stats")
            HomeScreenButton(onClick = { /*TODO*/ }, text = "Targets")
        }
}


@Composable
fun HomeScreenButton(
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick = onClick,
        shape = RectangleShape,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(20.dp),
        colors = ButtonDefaults.buttonColors(Color.White)
    ) {
        HomeScreenText(text = text)
    }
}

@Composable
fun HomeScreenText(text: String) {
    return Text(
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        color = Burgundy
    )
}