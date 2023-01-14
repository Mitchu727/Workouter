package com.example.workouter.screens.reps_counter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workouter.TIMER_DESTINATION
import com.example.workouter.model.Exercise
import com.example.workouter.model.service.StorageService
import kotlinx.coroutines.launch

class RepsCounterViewModel(
    val storageService: StorageService
): ViewModel() {
    // TODO czy to powinno być mutowalne
    var repsNumber by mutableStateOf(0)
    var exercise: Exercise = Exercise()

    fun clickOnClicker() {
        repsNumber += 1
    }

    fun clickOnSubmit(
        goTo: (String) -> Unit,
    ) {
        goTo(TIMER_DESTINATION)
        repsNumber = 0
    }

    fun getExercise(exerciseId: String): Exercise {
        if(exerciseId != exercise.id){
            viewModelScope.launch {
                exercise = storageService.getExercise(exerciseId) ?: exercise
            }
        }
        return exercise
    }

}