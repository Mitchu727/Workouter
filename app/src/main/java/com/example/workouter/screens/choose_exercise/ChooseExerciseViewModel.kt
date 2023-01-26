package com.example.workouter.screens.choose_exercise

import android.content.ContentValues
import android.util.Log
import com.example.workouter.EXERCISE_ID
import com.example.workouter.REPS_COUNTER_DESTINATION
import com.example.workouter.model.Exercise
import com.example.workouter.model.service.StorageService

class ChooseExerciseViewModel (
    private val storageService: StorageService,
) {
    val exercises = storageService.exercises

    fun onExerciseClick(
        goTo: (String) -> Unit,
        exercise: Exercise,
    ) {
        Log.d(ContentValues.TAG, "View model: request to go to exercise with id: ${exercise.id}")
        goTo("${REPS_COUNTER_DESTINATION}?exerciseId=${exercise.id}")
    }
}