package com.example.workouter.screens.choose_exercise

import com.example.workouter.RepsCounterDestination
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
        goTo("${RepsCounterDestination.route}?exerciseId=${exercise.id}")
    }
}