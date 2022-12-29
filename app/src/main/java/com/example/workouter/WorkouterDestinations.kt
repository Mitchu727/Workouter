package com.example.workouter

interface WorkouterDestination {
    val route: String
}

object TimerDestination: WorkouterDestination {
    override val route: String = "timer"
}

object RepsCounterDestination: WorkouterDestination {
    override val route: String = "repsCounter"
}

object PlannerDestination: WorkouterDestination {
    override val route: String = "plannerDestination"
}