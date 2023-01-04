package com.example.workouter.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workouter.domain.Exercise
import com.example.workouter.domain.ExerciseType
import com.example.workouter.ui.components.trainingpart.NameComponent
import com.example.workouter.ui.components.trainingpart.SeriesComponent
import com.example.workouter.ui.components.trainingpart.TypeComponent

@Preview
@Composable
fun PreTrainingPart() {
    var exercise: Exercise = Exercise(
        name = "Pompki",
        type = ExerciseType.COUNTED
    )
    TrainingPart(
        modifier = Modifier,
        exercise = exercise
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainingPart(
    modifier: Modifier,
    exercise: Exercise
) {
    Card(modifier = modifier)
    {
        Column {
            TextField(
                value = exercise.name,
                onValueChange = { exercise.name = it },
                label = { Text("Exercise:") }
            )
            NameComponent(exerciseNameToDisplay = exercise.name, setName = {exercise.name = it})
            SeriesComponent(seriesNumberToDisplay = exercise.series.toString(), setSeries = {exercise.series = it})
            TypeComponent(currentTypeName = exercise.type.toString(), setType = {exercise.type = it})
//            Text(
//                text = "Series: ${exercise.Series}",
//                modifier = Modifier.padding(12.dp),
//                color = Color.Black
//            )
//            DropdownMenuForTypes()
        }
    }
}

fun checkStringIsNumber(potentialStringNumber: String): Boolean {
    return potentialStringNumber.toIntOrNull() != null
}

@Composable
fun LabelText(text: String) {
    Text(
        text = text,
        fontSize = 12.sp
    )
}


@Composable
fun ErrorText(text: String) {
    Text(
        text = text,
        fontSize = 12.sp,
        color = Color.Red,
        modifier = Modifier.padding(12.dp)
    )
}