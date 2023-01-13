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

object HomeDestination: WorkouterDestination {
    override val route: String = "homeDestination"
}

object ExercisesDestination: WorkouterDestination {
    override val route: String = "exercisesDestination"
}

object EditExerciseDestination: WorkouterDestination {
    override val route: String = "editExerciseDestination"
}

object ChooseExerciseDestination: WorkouterDestination {
    override val route: String = "chooseExerciseDestination"
}

