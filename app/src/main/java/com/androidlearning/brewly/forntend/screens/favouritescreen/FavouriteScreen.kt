package com.androidlearning.brewly.forntend.screens.favouritescreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.androidlearning.brewly.R
import com.androidlearning.brewly.domain.model.Product
import com.androidlearning.brewly.forntend.ui_components.MyBottomNavBar

@Composable
fun FavouriteScreen(navController: NavHostController) {
    var favouriteProducts by remember {
        mutableStateOf(
            listOf(
                Product(id = 1, name = "Espresso", description = "Strong and rich", price = 3.80, imageRes = R.drawable.coffee_2),
                Product(id = 2, name = "Latte", description = "Smooth and creamy", price = 4.50, imageRes = R.drawable.coffee_3),
                Product(id = 3, name = "Cappuccino", description = "With chocolate", price = 4.20, imageRes = R.drawable.coffee_1)
            )
        )
    }

    Scaffold(
        topBar = { FavouriteTopAppBar() },
        bottomBar = { MyBottomNavBar(navController, "Favorites") }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            item {
                favouriteProducts.forEach { product ->
                    FavouriteItemCard(
                        favouriteProduct = product,
                        onRemove = { favouriteProducts = favouriteProducts - product }
                    )
                }
            }
        }
    }
}