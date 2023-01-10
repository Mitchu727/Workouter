package com.example.workouter.screens.edit_exercise

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import com.example.workouter.ui.components.LabelText
import com.example.workouter.ui.theme.Burgundy


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditExerciseScreen(
    popUpScreen: () -> Unit,
    viewModel: EditExerciseViewModel,
    exerciseId: String
)
{
    val exercise by viewModel.exercise
    LaunchedEffect(Unit) { viewModel.initialize(exerciseId) }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = exercise.name,
            onValueChange = {viewModel.onNameChange(it)},
            label = { LabelText(text = "Name") },
        )
        Button(
            onClick = {viewModel.onDoneClicked(popUpScreen)},
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(
                text = "Done",
                style = MaterialTheme.typography.headlineLarge,
                color = Burgundy
            )
        }
    }

}

//fun NameComponent(
//    exerciseNameToDisplay: String,
//    setName: (String) -> Unit
//) {
//    TextField(
//        value = exerciseNameToDisplay,
//        onValueChange = setName,
//        label = { LabelText(text = "Exercise") },
//        colors = TextFieldDefaults.textFieldColors(
//            unfocusedIndicatorColor = Color.Transparent,
//            focusedIndicatorColor = Color.Transparent
//        )
//    )
//}