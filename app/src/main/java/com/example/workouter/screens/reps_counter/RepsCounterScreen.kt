package com.example.workouter.screens.reps_counter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import com.example.workouter.model.Exercise
import com.example.workouter.ui.theme.Burgundy

@Composable
fun RepsCounterScreen(
    viewModel: RepsCounterViewModel,
    exerciseId: String,
    goTo: (String) -> Unit,
) {
    var repsNumber = viewModel.repsNumber
    val exercise: Exercise = viewModel.getExercise(exerciseId)
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { viewModel.clickOnClicker() },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Burgundy)
        ) {
            Column(modifier = Modifier.wrapContentSize(Alignment.Center)) {
                Text(
                    text = exercise.name
                )
                Text(
                    text = "Reps (click to add):",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "$repsNumber",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.headlineLarge //TODO export typography
                )
            }
        }
        Button(
            onClick = { viewModel.clickOnSubmit (goTo) },
            modifier = Modifier.fillMaxSize(),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color.DarkGray)
        ) {
            Text(
                text = "Submit",
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}