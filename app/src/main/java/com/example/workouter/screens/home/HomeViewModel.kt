package com.example.workouter.screens.home

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workouter.CHOOSE_EXERCISE_DESTINATION
import com.example.workouter.EXERCISES_DESTINATION
import com.example.workouter.model.Training
import com.example.workouter.model.service.StorageService
import com.example.workouter.model.service.TrainingService
import kotlinx.coroutines.launch

class HomeViewModel(
    val trainingService: TrainingService
): ViewModel() {
    fun onStartTrainingClick(goTo: (String) -> Unit) {
        Log.d(ContentValues.TAG, "Click on start training on home screen")
        viewModelScope.launch {
            trainingService.startNewTraining()
            goTo(CHOOSE_EXERCISE_DESTINATION)
        }
    }

    fun onExercisesClick(goTo: (String) -> Unit) {
        Log.d(ContentValues.TAG, "Click on exercises on home screen")
        goTo(EXERCISES_DESTINATION)
    }

    fun onStatsClick(goTo: (String) -> Unit) {
        Log.d(ContentValues.TAG, "Click on stats on home screen")
    }

    fun onTargetsClick(goTo: (String) -> Unit) {
        Log.d(ContentValues.TAG, "Click on targets on home screen")
    }
}