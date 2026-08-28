package com.androidlearning.brewly.screens.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidlearning.brewly.R
import com.androidlearning.brewly.ui.theme.LightBrown

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreen() {

    // Creates the main container for the entire welcome screen.
    // Box allows the image and the content to be placed on top of each other.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {

        // Displays the welcome/background image.
        // painterResource() loads the image from the drawable resources.
        Image(
            painter = painterResource(R.drawable.homescreen),
            contentDescription = "Welcome Image"
        )

        // Contains the text and button displayed at the bottom of the screen.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = 70.dp,
                    horizontal = 24.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            // Main heading of the welcome screen.
            Text(
                text = "Fall in Love with Coffee with Blissful Delight!",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            // Adds vertical space between the heading and subtitle.
            Spacer(modifier = Modifier.height(16.dp))

            // Supporting description below the main heading.
            Text(
                text = "Welcome to our cozy coffee corner",
                color = Color.LightGray,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )

            // Adds more space before the Get Started button.
            Spacer(modifier = Modifier.height(50.dp))

            // Get Started button for entering the main application.
            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),

                // NEW CONCEPT — ButtonDefaults.buttonColors
                // Used to customize the colors of the Material 3 Button.
                colors = ButtonDefaults.buttonColors(
                    // Uses a custom color defined in the app's theme.
                    containerColor = LightBrown,
                    contentColor = Color.White
                ),

                // Rounds the corners of the button.
                shape = RoundedCornerShape(12.dp)
            ) {

                // Text displayed inside the Get Started button.
                Text(
                    text = "Get Started",
                    fontSize = 18.sp
                )
            }
        }
    }
}