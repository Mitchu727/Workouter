package com.example.workouter.screens.timer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workouter.WHAT_NEXT_DESTINATION
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TimerViewModel(): ViewModel() {

    var timeLeft by mutableStateOf<Long>(60)

    fun timerFinished(goTo: (String) -> Unit) {
        goTo(WHAT_NEXT_DESTINATION)
    }

    fun setTimer(
        timeToSet: Long,
    ) {
        timeLeft = timeToSet
    }

    fun decreaseTime(){
        timeLeft-=1
    }

    fun startTimer(
        goTo: (String) -> Unit
    ) {
        runBlocking {
        launch {
            if(timeLeft > 0) {
                delay(1000L)
                timeLeft -= 1L
                println(timeLeft)
            }
            if (timeLeft <= 0) {
                timerFinished(goTo)
            }
        }
    }
    }
}