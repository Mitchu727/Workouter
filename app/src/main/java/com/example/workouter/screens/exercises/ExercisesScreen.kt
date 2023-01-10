package com.example.workouter.ui.components

import android.content.ContentValues
import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.workouter.model.Exercise
import com.example.workouter.screens.exercises.ExercisesViewModel
import com.example.workouter.ui.theme.Burgundy

// tu powinien być load
//val activities: List<String> = listOf("Pompki", "Podciągnięcia", "Przysiady")

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun ExercisesScreen(
    viewModel: ExercisesViewModel,
    goTo: (String) -> Unit
) {
    val exercises: State<List<Exercise>> = viewModel.exercises.collectAsStateWithLifecycle(emptyList())
    Log.d(ContentValues.TAG, "Fetched activities ${exercises}")
    Surface(
        color = Burgundy,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            AddExerciseButton(onClick = { viewModel.onAddClick(goTo) }, modifier = Modifier.fillMaxWidth())
            LazyColumn(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
            ) {
                items(exercises.value) { exercise ->
                    ExerciseView(exercise) { viewModel.onExerciseClick(goTo, exercise) }
                }
            }
//            Submitter(
//                onSubmitClicked = { Log.d(ContentValues.TAG, "Fetched activities ${exercises}") },
//                modifier = Modifier.fillMaxSize(),
//                text = "Save"
//            )
        }

    }
}

@Composable
fun AddExerciseButton(
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseView(
    exercise: Exercise,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        onClick = onClick
    ) {
        Text(text = exercise.name, modifier = Modifier.padding(8.dp))
    }
}