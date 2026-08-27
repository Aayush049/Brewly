package com.androidlearning.brewly.screens.homescreen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidlearning.brewly.R
import com.androidlearning.brewly.model.Product
import com.androidlearning.brewly.screens.ui_components.MyBottomNavBar

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {

    val location = ""

    Scaffold(
        bottomBar = { MyBottomNavBar() }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxWidth()
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {

            //Displaying Products Dummy Data
            val products = listOf(
                Product(id = 1, name = "Espresso", description = "Strong and rich", price = 3.80, imageRes = R.drawable.coffee_2),
                Product(id = 2, name = "Latte", description = "Smooth and creamy", price = 4.50, imageRes = R.drawable.coffee_3),
                Product(id = 3, name = "Cappuccino", description = "With chocolate", price = 4.20, imageRes = R.drawable.coffee_1),
                Product(id = 4, name = "Mocha", description = "With cocoa flavor", price = 4.70, imageRes = R.drawable.coffee_4),
                Product(id = 5, name = "Macchiato", description = "Bold and milky", price = 4.60, imageRes = R.drawable.coffee_5),
                Product(id = 6, name = "Flat White", description = "Velvety smooth", price = 4.40, imageRes = R.drawable.coffee_6),
                Product(id = 7, name = "Iced Mocha", description = "Refreshing and rich", price = 4.70, imageRes = R.drawable.coffee_4)
            )

            ProductsGrid(products = products) {  // Products Grid Component
                Text(
                    text = "Location:",
                    color = Color.Gray,
                    fontSize = 16.sp,
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = location,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change location",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                SearchBar() // Search Bar Component

                Spacer(modifier = Modifier.height(25.dp))

                Image(
                    painter = painterResource(R.drawable.banner_1),
                    contentDescription = "Home Banner"
                )

                Spacer(modifier = Modifier.height(15.dp))

                HomeScreenCatagories() // Catagories Component Added
            }
        }
    }
}