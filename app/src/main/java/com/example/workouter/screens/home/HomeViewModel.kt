package com.example.workouter.screens.home

import android.content.ContentValues
import android.util.Log
import com.example.workouter.ChooseExerciseDestination
import com.example.workouter.ExercisesDestination

class HomeViewModel {
    fun onStartTrainingClick(goTo: (String) -> Unit) {
        Log.d(ContentValues.TAG, "Click on start training on home screen")
        goTo(ChooseExerciseDestination.route)
    }

    fun onExercisesClick(goTo: (String) -> Unit) {
        Log.d(ContentValues.TAG, "Click on exercises on home screen")
        goTo(ExercisesDestination.route)
    }

    fun onStatsClick(goTo: (String) -> Unit) {
        Log.d(ContentValues.TAG, "Click on stats on home screen")
    }

    fun onTargetsClick(goTo: (String) -> Unit) {
        Log.d(ContentValues.TAG, "Click on targets on home screen")
    }
}