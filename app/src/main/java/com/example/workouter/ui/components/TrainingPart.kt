package com.example.workouter.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TrainingPart(
    number: Int,
    modifier: Modifier
) {
    Card(modifier = modifier)
    {
        Text(
            text = "Exercise: $number",
            modifier = Modifier.padding(12.dp),
            color = Color.Black
        )
    }
}