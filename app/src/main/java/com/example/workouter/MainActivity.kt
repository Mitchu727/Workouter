package com.example.workouter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workouter.domain.Reporter
import com.example.workouter.ui.components.RepsCounter
import com.example.workouter.ui.components.TimerScreen
import com.example.workouter.ui.theme.WorkouterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val reporter: Reporter = Reporter()
        setContent {
            WorkouterTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = TimerDestination.route,
                ) {
                    composable(route = RepsCounterDestination.route) {
                        RepsCounter(
                            reporter=reporter,
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


