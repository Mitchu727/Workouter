package com.example.workouter.screens.choose_exercise

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.workouter.model.Exercise
import com.example.workouter.ui.components.ExerciseView
import com.example.workouter.ui.theme.Burgundy

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun ChooseExerciseScreen (
    viewModel: ChooseExerciseViewModel,
    goTo: (String) -> Unit
) {
    val exercises: State<List<Exercise>> = viewModel.exercises.collectAsStateWithLifecycle(emptyList())
    Surface(
        color = Burgundy,
        modifier = Modifier.fillMaxSize()
    ) {
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
    }
}