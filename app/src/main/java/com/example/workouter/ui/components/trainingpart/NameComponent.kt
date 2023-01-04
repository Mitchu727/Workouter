package com.example.workouter.ui.components.trainingpart

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.workouter.ui.components.LabelText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameComponent(
    exerciseNameToDisplay: String,
    setName: (String) -> Unit
) {
    TextField(
        value = exerciseNameToDisplay,
        onValueChange = setName,
        label = { LabelText(text = "Exercise") },
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        )
    )
}