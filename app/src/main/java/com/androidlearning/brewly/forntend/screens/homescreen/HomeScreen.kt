package com.androidlearning.brewly.forntend.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.androidlearning.brewly.R
import com.androidlearning.brewly.domain.model.Product
import com.androidlearning.brewly.forntend.ui_components.MyBottomNavBar

@Composable
fun HomeScreen(navController: NavHostController) {

    // Stores the current location displayed on the Home screen.
    // Currently empty because real location functionality has not been added yet.
    val location = "Patia, Bhubneshwar"

    // KNOWN CONCEPT — Scaffold
    // Provides the overall structure of the Home screen.
    // The bottom navigation bar is supplied through the bottomBar slot.
    Scaffold(
        bottomBar = { MyBottomNavBar() }
    ) { innerPadding ->

        // NEW CONCEPT — Brush / Gradient
        // Creates a dark gradient background for the upper section of the screen.
        Box(
            modifier = Modifier
                .fillMaxWidth()

                // Takes one-third of the available height.
                .fillMaxHeight(1f / 3f)

                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF303030),
                            Color(0xFF1F1F1F),
                            Color(0xFF121212)
                        )
                    )
                )
        )

        // Main content of the Home screen.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

                // KNOWN CONCEPT — innerPadding
                // Keeps the content inside the safe area provided by Scaffold.
                .padding(innerPadding)
        ) {

            // Creates dummy product data for displaying products in the UI.
            // The Product data class defined in the model package is used here.
            val products = listOf(
                Product(id = 1, name = "Espresso", description = "Strong and rich", price = 3.80, imageRes = R.drawable.coffee_2),
                Product(id = 2, name = "Latte", description = "Smooth and creamy", price = 4.50, imageRes = R.drawable.coffee_3),
                Product(id = 3, name = "Cappuccino", description = "With chocolate", price = 4.20, imageRes = R.drawable.coffee_1),
                Product(id = 4, name = "Mocha", description = "With cocoa flavor", price = 4.70, imageRes = R.drawable.coffee_4),
                Product(id = 5, name = "Macchiato", description = "Bold and milky", price = 4.60, imageRes = R.drawable.coffee_5),
                Product(id = 6, name = "Flat White", description = "Velvety smooth", price = 4.40, imageRes = R.drawable.coffee_6),
                Product(id = 7, name = "Iced Mocha", description = "Refreshing and rich", price = 4.70, imageRes = R.drawable.coffee_4)
            )

            // ProductsGrid is a reusable component responsible for displaying
            // the product collection and the content passed into its content slot.
            ProductsGrid(products = products, navController = navController) {
                // Displays the "Location:" label.
                Text(
                    text = "Location:",
                    color = Color.Gray,
                    fontSize = 16.sp,
                )

                // Groups the location text and dropdown icon horizontally.
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Displays the current location.
                    Text(
                        text = location,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )

                    // Adds spacing between elements.
                    Spacer(modifier = Modifier.height(4.dp))

                    // Displays a downward arrow indicating that the location
                    // can potentially be changed.
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change location",
                        tint = Color.White
                    )
                }

                // Adds spacing before the search bar.
                Spacer(modifier = Modifier.height(25.dp))

                // Search bar component added to the Home screen.
                SearchBar()

                // Adds spacing between the search bar and banner.
                Spacer(modifier = Modifier.height(25.dp))

                // Displays the promotional banner on the Home screen.
                Image(
                    painter = painterResource(R.drawable.banner_1),
                    contentDescription = "Home Banner"
                )

                // Adds spacing before the categories section.
                Spacer(modifier = Modifier.height(15.dp))

                // Categories component added below the banner.
                HomeScreenCategories()
            }
        }
    }
}