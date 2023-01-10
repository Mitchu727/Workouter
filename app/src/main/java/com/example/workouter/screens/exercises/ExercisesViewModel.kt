package com.example.workouter.screens.exercises

import com.example.workouter.EditExerciseDestination
import com.example.workouter.model.service.StorageService

class ExercisesViewModel (
    private val storageService: StorageService
) {
    val exercises = storageService.exercises

    fun onAddClick(goTo: (String) -> Unit) = goTo(EditExerciseDestination.route)

    fun onExerciseClick(
        goTo: (String) -> Unit,
        exercise: String
    ) {
       goTo("$EditExerciseDestination.route?exerciseId]{}")
    }
}