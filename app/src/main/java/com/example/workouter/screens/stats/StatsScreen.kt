package com.example.workouter.screens.stats

import StatsViewModel
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.workouter.model.TrainingPart
import com.example.workouter.ui.theme.Burgundy

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun StatsScreen (
    popUpScreen: () -> Unit,
    viewModel: StatsViewModel,
    exerciseId: String
) {
    val trainingParts: State<List<TrainingPart>> = viewModel.trainingParts.collectAsStateWithLifecycle(emptyList())
//    val validTrainingParts = trainingParts.value.filter { it.id == exerciseId }
    Surface(
        color = Burgundy,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            items(trainingParts.value) { trainingPart ->
                TrainingPartView(trainingPart)
            }
        }
    }
}

@Composable
fun TrainingPartView(
    trainingPart: TrainingPart
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Text(text = trainingPart.repsCount.toString(), modifier = Modifier.padding(8.dp))
    }
}