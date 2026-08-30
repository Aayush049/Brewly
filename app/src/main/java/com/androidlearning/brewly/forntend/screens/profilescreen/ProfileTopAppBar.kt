package com.androidlearning.brewly.forntend.screens.profilescreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopAppBar() {
    // Creates the top app bar for the Cart screen.
    TopAppBar(
        title = {
            Text(
                text = "Profile",
                modifier = Modifier
                    .fillMaxWidth(),
                fontWeight = FontWeight.Bold
            )
        }
    )
}