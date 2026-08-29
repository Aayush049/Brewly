package com.androidlearning.brewly.forntend.screens.detailsscreen

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
import com.androidlearning.brewly.R

// NEW — Required because TopAppBar is currently marked experimental.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreenTopAppBar() {

    // Creates the top app bar for the Details screen.
    TopAppBar(
        title = {
            Text(
                text = "Details",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        },

        // Favorite icon added to the right side of the app bar.
        actions = {
            Icon(
                painter = painterResource(R.drawable.regular_outline_heart),
                contentDescription = "Favorite",
                modifier = Modifier
                    .padding(end = 16.dp)
            )
        },

        // Back arrow added to the left side of the app bar.
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.regular_outline_arrow_left),
                contentDescription = "Back Button",
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        }
    )
}