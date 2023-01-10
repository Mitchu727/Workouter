package com.example.workouter.ui.components

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workouter.ui.theme.Burgundy

// tu powinien być load
//val activities: List<String> = listOf("Pompki", "Podciągnięcia", "Przysiady")

@Composable
fun ActivitiesScreen(
    names: List<String>,
    saveNewActivities: (List<String>) -> Unit
) {
    val activities = names
    Log.d(ContentValues.TAG, "Fetched activities ${activities}")
    Surface(
        color = Burgundy,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
            ) {
                items(activities) { activity ->
                    ActivityCard(text = activity)
                }
            }
            Submitter(
                onSubmitClicked = { saveNewActivities(activities) },
                modifier = Modifier.fillMaxSize(),
                text = "Save"
            )
        }

    }
}

@Composable
fun ActivityCard(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Text(text = text, modifier = Modifier.padding(8.dp))
    }
}