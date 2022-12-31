package com.example.workouter.ui.components

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
    onFinishGoTo: () -> Unit
) {
    var timeLeft by rememberSaveable { mutableStateOf<Long>(5) }
    var finished by rememberSaveable { mutableStateOf(false) }
    ExerciseTimer(
        currentTime = 5,
        onTick = { timeLeft -= 1 },
        onFinish = {finished=true}
    )
    if (!finished) {
        ShowTime(timeLeft)
    } else {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
                .wrapContentSize(Alignment.Center),
            text = "Done!",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
        )
        onFinishGoTo()
    }
}

@Composable
fun ExerciseTimer(
    currentTime: Long,
    timeInterval: Long = 1000L,
    onTick: () -> Unit,
    onFinish: () -> Unit,
) {
    var timeLeft by remember {mutableStateOf(currentTime * 1L)}
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