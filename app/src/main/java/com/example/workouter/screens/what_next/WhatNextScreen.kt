package com.example.workouter.screens.what_next

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import com.example.workouter.ui.theme.Burgundy

@Composable
fun WhatNextScreen(
    viewModel: WhatNextViewModel,
    goTo: (String) -> Unit
) {
    Column {
        Button(
            onClick = { viewModel.clickOnContinue(goTo) },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Burgundy)
        ) {
            Text(
                text = "Continue training",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )
        }
        Button(
            onClick = { viewModel.clickOnEndTraining(goTo) },
            modifier = Modifier.fillMaxSize(),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(
                text = "End training",
                style = MaterialTheme.typography.headlineLarge,
                color = Burgundy
            )
        }
    }
}