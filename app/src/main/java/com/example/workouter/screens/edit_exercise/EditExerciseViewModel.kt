package com.example.workouter.screens.edit_exercise

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import com.example.workouter.model.Exercise
import com.example.workouter.model.service.StorageService
import com.example.workouter.ui.components.ExerciseView
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.launch

class EditExerciseViewModel (
    private val storageService: StorageService
    ): ViewModel() //TODO doczytać po co to dziedziczenie
{
    val exercise = mutableStateOf(Exercise())
    fun initialize(exerciseId: String) {
        viewModelScope.launch {
            exercise.value = storageService.getExercise(exerciseId) ?: Exercise(id = Exercise.generateRandomUUID())
            Log.d(ContentValues.TAG, "Initialization of edit exercise view model with id: ${exercise.value.id}")
        }
    }

    fun onNameChange(newValue: String) {
        exercise.value = exercise.value.copy(name = newValue)
    }

    fun onDoneClicked(popupScreen: () -> Unit) {
        viewModelScope.launch {
            val editedExercise = exercise.value
            if (editedExercise.id.isBlank()) {
                storageService.saveExercise(editedExercise)
            } else {
                storageService.updateExercise(editedExercise)
            }
            popupScreen()
        }
    }


}