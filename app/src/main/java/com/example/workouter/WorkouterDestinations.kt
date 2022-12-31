package com.example.workouter

interface WorkouterDestination {
    val route: String
}

object TimerDestination: WorkouterDestination {
    override val route: String = "timer"
}

object RepsCounterDestination: WorkouterDestination {
    override val route: String = "reps-counter"
}