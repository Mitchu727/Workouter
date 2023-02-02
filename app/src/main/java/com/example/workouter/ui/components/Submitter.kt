package com.example.workouter.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

@Composable
fun Submitter(
    onSubmitClicked: ()->Unit,
    modifier: Modifier,
    text: String = "Submit"
){
    Button(
        onClick = onSubmitClicked,
        modifier = modifier,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Color.DarkGray)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineLarge)
    }
}