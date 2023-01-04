package com.example.workouter.ui.components.trainingpart

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.workouter.ui.components.ErrorText
import com.example.workouter.ui.components.LabelText
import com.example.workouter.ui.components.checkStringIsNumber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeriesComponent(
    seriesNumberToDisplay: String,
    setSeries: (Int) -> Unit
) {
    var textFieldContent by remember { mutableStateOf(seriesNumberToDisplay) }
    TextField(
        value = textFieldContent,
        onValueChange = { textFieldContent = it },
        label = { LabelText(text = "Series") },
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent
        )
    )
    if (!checkStringIsNumber(textFieldContent)) {
        ErrorText(text= "The value should be a number")
    } else {
        val seriesValue: Int =  textFieldContent.toInt()
        if (seriesValue == 0) {
            ErrorText(text= "The value should be greater than zero you lump!")
        }
        else {
            setSeries(seriesValue)
        }
    }
}