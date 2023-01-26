package com.example.workouter.screens.timer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.workouter.ui.theme.Burgundy
import kotlinx.coroutines.delay

@Composable
fun TimerScreen(
    goTo: (String) -> Unit,
    viewModel: TimerViewModel
) {
    var timeLeft = viewModel.timeLeft
    ExerciseTimer(
        currentTime = 5L,
        onTick = {viewModel.decreaseTime()},
        onFinish = {viewModel.timerFinished(goTo)})
    ShowTime(timeLeft)
}

@Composable
fun ExerciseTimer(
    currentTime: Long,
    timeInterval: Long = 1000L,
    onTick: () -> Unit,
    onFinish: () -> Unit,
) {
    var timeLeft by remember { mutableStateOf(currentTime * 1L) }
    LaunchedEffect(key1 = timeLeft, block = {
        if(timeLeft > 0) {
            delay(timeInterval)
            timeLeft -= 1L
            println(timeLeft)
            onTick()
        }
        if (timeLeft <= 0) {
            onFinish()
        }
    })
}

@Composable
fun ShowTime(timeLeft: Long) {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .background(Burgundy)
            .wrapContentSize(Alignment.Center),
        text = timeLeft.toString(),
        style = MaterialTheme.typography.headlineLarge,
        color = Color.White,
    )
}