package com.example.workouter

import StatsViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.workouter.model.service.DefaultTrainingService
import com.example.workouter.model.service.StorageService
import com.example.workouter.model.service.TrainingService
import com.example.workouter.model.service.firebase_implementation.FirebaseStorageService
import com.example.workouter.screens.choose_exercise.ChooseExerciseScreen
import com.example.workouter.screens.choose_exercise.ChooseExerciseViewModel
import com.example.workouter.screens.choose_exercise.StatsChooseExerciseScreen
import com.example.workouter.screens.choose_exercise.StatsChooseExerciseViewModel
import com.example.workouter.screens.edit_exercise.EditExerciseScreen
import com.example.workouter.screens.edit_exercise.EditExerciseViewModel
import com.example.workouter.screens.exercises.ExercisesViewModel
import com.example.workouter.screens.home.HomeScreen
import com.example.workouter.screens.home.HomeViewModel
import com.example.workouter.screens.reps_counter.RepsCounterScreen
import com.example.workouter.screens.reps_counter.RepsCounterViewModel
import com.example.workouter.screens.stats.StatsScreen
import com.example.workouter.screens.timer.TimerScreen
import com.example.workouter.screens.timer.TimerViewModel
import com.example.workouter.screens.what_next.WhatNextScreen
import com.example.workouter.screens.what_next.WhatNextViewModel
import com.example.workouter.ui.components.*
import com.example.workouter.ui.theme.WorkouterTheme
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val storageService: StorageService = FirebaseStorageService(Firebase.firestore)
        val trainingService: TrainingService = DefaultTrainingService(storageService)
        //TODO viewmodele - jeśli będzie czas to zamienić na dependency injection
        val exercisesViewModel = ExercisesViewModel(storageService)
        val editExerciseViewModel = EditExerciseViewModel(storageService)
        val chooseExerciseViewModel = ChooseExerciseViewModel(storageService)
        val repsCounterViewModel = RepsCounterViewModel(storageService, trainingService)
        val homeViewModel = HomeViewModel(trainingService, storageService)
        val whatNextViewModel = WhatNextViewModel()
        val statsChooseExerciseViewModel = StatsChooseExerciseViewModel(storageService)
        val timerViewModel = TimerViewModel()
        val statsViewModel = StatsViewModel(storageService)

        setContent {
            WorkouterTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = HOME_DESTINATION,
                ) {
                    composable(
                        route = "$REPS_COUNTER_DESTINATION?$EXERCISE_ID_ARGS",
                        arguments = listOf(navArgument(EXERCISE_ID) {
                            defaultValue = DEFAULT_EXERCISE_ID
                        })
                    ) {
                        var exerciseId: String =
                            it.arguments?.getString(EXERCISE_ID) ?: DEFAULT_EXERCISE_ID
                        RepsCounterScreen(
                            viewModel = repsCounterViewModel,
                            goTo = { route -> navController.navigateSingleTopTo(route) },
                            exerciseId = exerciseId,
                        )
                    }
                    composable(
                        route = TIMER_DESTINATION
                    ) {
                        timerViewModel.setTimer(5)
                        TimerScreen(
                            viewModel = timerViewModel,
                            goTo = { route -> navController.navigateSingleTopTo(route) }
                        )
                    }
                    composable(route = PLANNER_DESTINATION) {
                        PlannerScreen()
                    }
                    composable(route = HOME_DESTINATION) {
                        HomeScreen(
                            viewModel = homeViewModel,
                            goTo = { route -> navController.navigateSingleTopTo(route) }
                        )
                    }
                    composable(route = EXERCISES_DESTINATION) {
                        ExercisesScreen(
                            viewModel = exercisesViewModel,
                            goTo = { route -> navController.navigateSingleTopTo(route) }
                        )
                    }
                    composable(
                        route = "$EDIT_EXERCISE_DESTINATION?$EXERCISE_ID_ARGS",
                        arguments = listOf(navArgument(EXERCISE_ID) {
                            defaultValue = DEFAULT_EXERCISE_ID
                        })
                        //TODO extract to constants: +1 because it already caused one error
                    ) {
                        EditExerciseScreen(
                            popUpScreen = { navController.popBackStack() },
                            viewModel = editExerciseViewModel,
                            exerciseId = it.arguments?.getString(EXERCISE_ID) ?: DEFAULT_EXERCISE_ID
                        )
                    }
                    composable(
                        route = "$STATS_DESTINATION?$EXERCISE_ID_ARGS",
                        arguments = listOf(navArgument(EXERCISE_ID) {
                            defaultValue = DEFAULT_EXERCISE_ID
                        })
                        //TODO extract to constants: +1 because it already caused one error
                    ) {
                        StatsScreen(
                            popUpScreen = { navController.popBackStack() },
                            viewModel = statsViewModel,
                            exerciseId = it.arguments?.getString(EXERCISE_ID) ?: DEFAULT_EXERCISE_ID
                        )
                    }
                    composable(
                        route = CHOOSE_EXERCISE_DESTINATION
                    ) {
                        ChooseExerciseScreen(
                            viewModel = chooseExerciseViewModel,
                            goTo = {route -> navController.navigateV2(route)}
                        )
                    }
                    composable(
                        route = STATS_CHOOSE_EXERCISE_DESTINATION
                    ) {
                        StatsChooseExerciseScreen(
                            viewModel = statsChooseExerciseViewModel,
                            goTo = {route -> navController.navigateV2(route)}
                        )
                    }
                    composable(
                        route = WHAT_NEXT_DESTINATION
                    ) {
                        WhatNextScreen(
                            viewModel = whatNextViewModel,
                            goTo = {route -> navController.navigateSingleTopTo(route)}
                        )
                    }

                }
                // A surface container using the 'background' color from the theme
            }
        }
    }

}

fun NavHostController.navigateSingleTopTo(route: String) =
//    this.navigate(route)
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }


fun NavHostController.navigateV2(route: String) =
//    this.navigate(route)
    this.navigate(route) {
        popUpTo(
            this@navigateV2.graph.findStartDestination().id
        ) {
            saveState = false
        }
        launchSingleTop = true
        restoreState = false
    }


