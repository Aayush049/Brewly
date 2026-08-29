package com.androidlearning.brewly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.androidlearning.brewly.forntend.screens.homescreen.HomeScreen
import com.androidlearning.brewly.forntend.theme.BrewlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrewlyTheme {
                HomeScreen()
            }
        }
    }
}
