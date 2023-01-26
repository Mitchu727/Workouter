package com.example.workouter.screens.reps_counter

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workouter.TIMER_DESTINATION
import com.example.workouter.model.Exercise
import com.example.workouter.model.TrainingPart
import com.example.workouter.model.service.StorageService
import com.example.workouter.model.service.TrainingService
import kotlinx.coroutines.launch

class RepsCounterViewModel(
    val storageService: StorageService,
    val trainingService: TrainingService
): ViewModel() {
    // TODO czy to powinno być mutowalne
    var repsNumber by mutableStateOf(0)
    val exercise = mutableStateOf(Exercise())

    fun initialize(exerciseId: String) {
        viewModelScope.launch {
            exercise.value = storageService.getExercise(exerciseId) ?: Exercise(id = Exercise.generateRandomUUID())
            Log.d(ContentValues.TAG, "Initialization of reps counter view model with id: ${exercise.value.id}")
        }
    }

    fun clickOnClicker() {
        repsNumber += 1
    }

    fun clickOnSubmit(
        goTo: (String) -> Unit,
    ) {
        goTo(TIMER_DESTINATION)
        viewModelScope.launch {
            storageService.saveTrainingPart(
                TrainingPart(
                    id = TrainingPart.generateRandomUUID(),
                    exerciseId = exercise.value.id,
                    trainingId = trainingService.getCurrentTraining().id,
                    repsCount = repsNumber
                )
            )
        }
        repsNumber = 0
    }

}