package com.example.workouter.ui.components

import android.os.Parcelable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workouter.domain.Exercise
import com.example.workouter.domain.ExerciseType
import com.example.workouter.ui.theme.Burgundy

import kotlinx.parcelize.Parcelize

//TODO current way to display things on bottom or on top is probably not best

@Preview
@Composable
fun PlannerScreen() {
    Planner()
}

@Composable
fun Planner() {
    //TODO try to migrate to remembder saveable, current approach crashes
    // when you rotate the screen
    var exercises = remember { mutableStateListOf<Exercise>(
            Exercise("Podciaganie", ExerciseType.COUNTED, 3)
    ) }
    Surface(
        color = Burgundy,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
            ) {
                AddTrainingPartButton(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth(),
                    onClick = {
                        exercises.add(
                            Exercise(
                                name = "Pompki",
                                type = ExerciseType.COUNTED
                            ),
                        )
                    }
                )
                LazyColumn(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    items(exercises) { exercise ->
                        TrainingPart(
                            exercise = exercise,
                            modifier = Modifier
                                .padding(vertical = 4.dp, horizontal = 8.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
            Submitter(
                onSubmitClicked = { print(exercises) },
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun AddTrainingPartButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(Color.White)
    ) {
        Text(
            text = "+",
            color = Burgundy
        )
    }
}