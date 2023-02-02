package com.example.workouter.screens.choose_exercise

import com.example.workouter.REPS_COUNTER_DESTINATION
import com.example.workouter.STATS_DESTINATION
import com.example.workouter.model.Exercise
import com.example.workouter.model.service.StorageService

class StatsChooseExerciseViewModel (
    private val storageService: StorageService,
) {
    val exercises = storageService.exercises

    fun onExerciseClick(
        goTo: (String) -> Unit,
        exercise: Exercise,
    ) {
        goTo("${STATS_DESTINATION}?exerciseId=${exercise.id}")
    }
}