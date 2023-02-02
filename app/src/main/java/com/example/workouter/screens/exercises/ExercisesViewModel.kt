package com.example.workouter.screens.exercises

import com.example.workouter.EDIT_EXERCISE_DESTINATION
import com.example.workouter.model.Exercise
import com.example.workouter.model.service.StorageService

class ExercisesViewModel (
    private val storageService: StorageService
) {
    val exercises = storageService.exercises

    fun onAddClick(goTo: (String) -> Unit) = goTo(EDIT_EXERCISE_DESTINATION)

    fun onExerciseClick(
        goTo: (String) -> Unit,
        exercise: Exercise
    ) {
       goTo("${EDIT_EXERCISE_DESTINATION}?exerciseId=${exercise.id}")
    }
}