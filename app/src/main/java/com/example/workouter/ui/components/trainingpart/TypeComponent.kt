package com.example.workouter.ui.components.trainingpart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.workouter.domain.ExerciseType

@Composable
fun TypeComponent(
    currentTypeName: String,
    setType: (ExerciseType)->Unit
) {
    val items: Array<ExerciseType> = ExerciseType.values()
    Column {
        items.forEach {
            Row {
                RadioButton(
                    selected = (currentTypeName == it.toString()),
                    onClick = { setType(it) },
                )
                Text(text = it.toString())
            }

        }
    }
}