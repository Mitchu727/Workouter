package com.example.workouter.screens.stats

import StatsViewModel
import androidx.compose.foundation.layout.*
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
import java.text.SimpleDateFormat
import java.util.Date

fun formatDate(date: Date): String {
//    val formatter = SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//    return formatter.format(date)
    return "$date"
}

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun StatsScreen (
    viewModel: StatsViewModel,
    exerciseId: String
) {
    val trainingParts: State<List<TrainingPart>> = viewModel.trainingParts.collectAsStateWithLifecycle(emptyList())
    val validTrainingParts = trainingParts.value.filter { it.exerciseId == exerciseId }
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
            items(validTrainingParts) { trainingPart ->
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
        Row {
            Text(text = "${formatDate(trainingPart.date)}: ", modifier = Modifier.padding(8.dp))
            Text(text = trainingPart.repsCount.toString(), modifier = Modifier.padding(8.dp))
        }
    }
}