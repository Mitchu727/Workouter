package com.example.workouter.screens.home

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workouter.CHOOSE_EXERCISE_DESTINATION
import com.example.workouter.EXERCISES_DESTINATION
import com.example.workouter.model.NewTraining
import com.example.workouter.model.service.StorageService
import kotlinx.coroutines.launch

class HomeViewModel(
    val storageService: StorageService
): ViewModel() {
    fun onStartTrainingClick(goTo: (String) -> Unit) {
        Log.d(ContentValues.TAG, "Click on start training on home screen")
        viewModelScope.launch {
            val newTrainingId = storageService.createNewTraining(NewTraining.createNew())
        }
        goTo(CHOOSE_EXERCISE_DESTINATION)
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