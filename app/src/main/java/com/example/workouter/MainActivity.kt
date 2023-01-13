package com.example.workouter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.workouter.model.service.StorageService
import com.example.workouter.model.service.firebase_implementation.FirebaseStorageService
import com.example.workouter.screens.choose_exercise.ChooseExerciseScreen
import com.example.workouter.screens.choose_exercise.ChooseExerciseViewModel
import com.example.workouter.screens.edit_exercise.EditExerciseScreen
import com.example.workouter.screens.edit_exercise.EditExerciseViewModel
import com.example.workouter.screens.exercises.ExercisesViewModel
import com.example.workouter.screens.home.HomeScreen
import com.example.workouter.screens.home.HomeViewModel
import com.example.workouter.ui.components.*
import com.example.workouter.ui.theme.WorkouterTheme
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val storageService: StorageService = FirebaseStorageService(Firebase.firestore)
        val exercisesViewModel = ExercisesViewModel(storageService)
        val editExerciseViewModel = EditExerciseViewModel(storageService)
        val chooseExerciseViewModel = ChooseExerciseViewModel(storageService)
        val homeViewModel = HomeViewModel()
        setContent {
            WorkouterTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = HomeDestination.route,
                ) {
                    composable(route = RepsCounterDestination.route) {
                        RepsCounter(
                            onSubmitGoTo = {
                                navController.navigateSingleTopTo(TimerDestination.route)
                            }
                        )
                    }
                    composable(route = TimerDestination.route) {
                        TimerScreen(onFinishGoTo = {
                                navController.navigateSingleTopTo(RepsCounterDestination.route)
                        })
                    }
                    composable(route = PlannerDestination.route) {
                        PlannerScreen()
                    }
                    composable(route = HomeDestination.route) {
                        HomeScreen(
                            viewModel = homeViewModel,
                            goTo = {route -> navController.navigateSingleTopTo(route)}
                        )
                    }
                    composable(route = ExercisesDestination.route) {
                        ExercisesScreen(
                            viewModel = exercisesViewModel,
                            goTo = {route -> navController.navigateSingleTopTo(route)}
                        )
                    }
                    composable(
                        route = "${EditExerciseDestination.route}?exerciseId={exerciseId}",
                        arguments = listOf(navArgument("exerciseId") { defaultValue = "defaultId"})
                        //TODO extract to constants: +1 because it already caused one error
                    ) {
                        EditExerciseScreen(
                            popUpScreen = { navController.popBackStack() },
                            viewModel = editExerciseViewModel,
                            exerciseId = it.arguments?.getString("exerciseId")?: "some-default-value"
                        )
                    }
                    composable(
                        route = ChooseExerciseDestination.route,
                        arguments = listOf(navArgument("exerciseId") { defaultValue = "defaultId"})
                    ) {
                        ChooseExerciseScreen(
                            viewModel = chooseExerciseViewModel,
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


