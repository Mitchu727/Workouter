package com.example.workouter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.workouter.domain.Reporter
import com.example.workouter.ui.components.RepsCounter
import com.example.workouter.ui.theme.WorkouterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val reporter: Reporter = Reporter()
        setContent {
            WorkouterTheme {
                // A surface container using the 'background' color from the theme
                RepsCounter(reporter)
            }
        }
    }
}