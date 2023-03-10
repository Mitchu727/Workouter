package com.example.workouter.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.example.workouter.domain.Reporter
import com.example.workouter.ui.theme.Burgundy

@Composable
fun RepsCounter(
//    reporter: Reporter = Reporter(),
    onSubmitGoTo: () -> Unit
) {
    var repsNumber by remember { mutableStateOf(0) }
    Column {
        Clicker (
            onButtonClicked = { repsNumber += 1 },
            getRepsNumber = {repsNumber}
        )
        Submitter (
            modifier = Modifier.fillMaxSize(),
            onSubmitClicked = {
                repsNumber = 0
                onSubmitGoTo()
            }
        )
    }
}

@Composable
fun Clicker(
    onButtonClicked: () -> Unit,
    getRepsNumber: () -> Int
) {
    Button(
        onClick = onButtonClicked,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Burgundy)
    ){
        Column(modifier=Modifier.wrapContentSize(Alignment.Center)) {
            Text(
                text = "Reps (click to add):",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "${getRepsNumber()}",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.headlineLarge //TODO export typography
            )
        }
    }
}