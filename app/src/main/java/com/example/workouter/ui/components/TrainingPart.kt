package com.example.workouter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workouter.domain.Exercise
import com.example.workouter.domain.ExerciseType

@Preview
@Composable
fun PreTrainingPart() {
    var exercise: Exercise = Exercise(
        name = "Pompki",
        type = ExerciseType.COUNTED
    )
    TrainingPart(
        modifier = Modifier,
        exercise = exercise
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainingPart(
    modifier: Modifier,
    exercise: Exercise
) {
    Card(modifier = modifier)
    {
        Column {
            TextField(
                value = exercise.name,
                onValueChange = { exercise.name = it },
                label = { Text("Exercise:") }
            )
            Text(
                text = "Series: ${exercise.Series}",
                modifier = Modifier.padding(12.dp),
                color = Color.Black
            )
            DropdownMenuForTypes()
        }
    }
}

@Composable
fun DropdownMenuForTypes() {
    val items: Array<ExerciseType> = ExerciseType.values()
    var expanded by remember { mutableStateOf(false) }
    var selectedValue by remember { mutableStateOf(ExerciseType.TIMED.toString()) }
    ClickableText(
        text = AnnotatedString(selectedValue),
        onClick = { expanded = true },
        modifier = Modifier.padding(12.dp).fillMaxWidth()
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth(0.9f)
//            .padding(horizontal = 100.dp)
    )
    {
        items.forEachIndexed { itemIndex, itemValue ->
            DropdownMenuItem(
                text = {
                    Text(
                        text = itemValue.toString(),
                        color = Color.Black
                    )
                },
                onClick = {
                    selectedValue = itemValue.toString()
                    expanded = false
                },
            )
        }
    }
}

//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ExposedMenuExp() {
//    val listItems: Array<String> = ExerciseType.values().map { it.toString() }.toTypedArray()
//    var selectedItem by remember { mutableStateOf(listItems[0]) }
//    var expanded by remember { mutableStateOf(false) }
//    // the box
//    ExposedDropdownMenuBox(
//        expanded = expanded,
//        onExpandedChange = {
//            expanded = !expanded
//        }
//    ) {
//
//        // text field
//        TextField(
//            value = selectedItem,
//            onValueChange = {},
//            readOnly = true,
//            label = { Text(text = "Type") },
//            trailingIcon = {
//                ExposedDropdownMenuDefaults.TrailingIcon(
//                    expanded = expanded
//                )
//            },
//            colors = ExposedDropdownMenuDefaults.textFieldColors()
//        )
//
//        // menu
//        ExposedDropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            listItems.forEach { selectedOption ->
//                // menu item
//                DropdownMenuItem(onClick = {
//                    selectedItem = selectedOption
//                    expanded = false
//                },
//                    text = {Text(selectedOption)}
//                )
//            }
//        }
//    }
//}