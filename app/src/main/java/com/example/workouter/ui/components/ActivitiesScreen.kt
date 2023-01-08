package com.example.workouter.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workouter.ui.theme.Burgundy

// tu powinien być load
val activities: List<String> = listOf("Pompki", "Podciągnięcia", "Przysiady")

@Preview
@Composable
fun ActivitiesScreen() {
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
                onSubmitClicked = { /*TODO*/ },
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