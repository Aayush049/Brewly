package com.androidlearning.brewly.forntend.screens.cartscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.androidlearning.brewly.R
import com.androidlearning.brewly.forntend.navigation.Routes

// NEW — Required because TopAppBar is currently marked experimental.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartTopAppBar(navController: NavHostController) {

    // Creates the top app bar for the Details screen.
    TopAppBar(
        title = {
            Text(
                text = "Order Summary",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    )
}