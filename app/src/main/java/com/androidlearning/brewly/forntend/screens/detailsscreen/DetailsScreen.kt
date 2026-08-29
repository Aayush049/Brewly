package com.androidlearning.brewly.forntend.screens.detailsscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.androidlearning.brewly.R
import com.androidlearning.brewly.domain.model.Product

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsScreen() {

    // Dummy product data for the Details screen.
    val products = listOf(
        Product(id = 1, name = "Espresso", description = "Strong and rich", price = 3.80, imageRes = R.drawable.coffee_2),
        Product(id = 2, name = "Latte", description = "Smooth and creamy", price = 4.50, imageRes = R.drawable.coffee_3),
        Product(id = 3, name = "Cappuccino", description = "With chocolate", price = 4.20, imageRes = R.drawable.coffee_1),
        Product(id = 4, name = "Mocha", description = "With cocoa flavor", price = 4.70, imageRes = R.drawable.coffee_4),
        Product(id = 5, name = "Macchiato", description = "Bold and milky", price = 4.60, imageRes = R.drawable.coffee_5),
        Product(id = 6, name = "Flat White", description = "Velvety smooth", price = 4.40, imageRes = R.drawable.coffee_6),
        Product(id = 7, name = "Iced Mocha", description = "Refreshing and rich", price = 4.70, imageRes = R.drawable.coffee_4)
    )

    // NEW — Finds the first product matching the given condition.
    val selectedProduct = products.find { it.id == 1 }

    Scaffold(
        topBar = {
            DetailsScreenTopAppBar() // Details screen top app bar.
        },
        bottomBar = {
            DetailsScreenBottomAppBar() // Details screen bottom action bar.
        }
    ) { innerPadding ->

        // Makes the product details vertically scrollable.
        LazyColumn {

            // Adds product details as a single list item.
            item {
                ProductDetailsContent(
                    selectedProduct,
                    innerPadding
                ) // Error here will be solved later.
            }
        }
    }
}