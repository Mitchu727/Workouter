package com.example.workouter.screens.choose_exercise

import com.example.workouter.REPS_COUNTER_DESTINATION
import com.example.workouter.model.Exercise
import com.example.workouter.model.service.StorageService

class ChooseExerciseViewModel (
    private val storageService: StorageService,
) {
    val exercises = storageService.exercises

    fun onExerciseClick(
        goTo: (String) -> Unit,
        exercise: Exercise
    ) {
        goTo("${REPS_COUNTER_DESTINATION}?exerciseId=${exercise.id}")
    }
}