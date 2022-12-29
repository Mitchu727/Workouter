package com.example.workouter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workouter.ui.theme.Burgundy


@Preview
@Composable
fun PlannerScreen() {
    Planner()
}

@Composable
fun Planner() {
    Surface(
        color = Burgundy,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth()
        ) {
            for (i in 1..4) {
                TrainingPart(i)
            }
        }
    }
}

@Composable
fun TrainingPart(number: Int) {
    Card(modifier = Modifier
        .padding(vertical = 4.dp, horizontal = 8.dp)
        .fillMaxWidth()
    )
    {
        Text(
            text = "Exercise: $number",
            modifier = Modifier.padding(12.dp),
            color = Color.Black
        )
    }
}