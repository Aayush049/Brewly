package com.androidlearning.brewly.forntend.screens.homescreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.androidlearning.brewly.domain.model.Product

@Composable
fun ProductsGrid(
    products: List<Product>,
    navController: NavHostController,

    // NEW CONCEPT — Composable Lambda
    // Allows the caller to provide any Composable content that should
    // appear before the product list.
    topContent: @Composable () -> Unit
) {

    // KNOWN CONCEPT — LazyColumn
    // Creates a vertically scrolling list.
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        // Adds the content provided through the topContent lambda
        // as the first item of the LazyColumn.
        //
        // In HomeScreen, this contains:
        // Location → SearchBar → Banner → Categories
        item {
            topContent()
        }

        // NEW CONCEPT — chunked(2)
        // Splits the products list into smaller lists containing
        // at most 2 products each.
        //
        // Example:
        // [1, 2, 3, 4, 5]
        //
        // becomes:
        // [1, 2]
        // [3, 4]
        // [5]
        items(products.chunked(2)) { rowItems ->

            // Each chunk becomes one horizontal row.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                // First product in the current row.
                ProductCard(
                    product = rowItems[0],
                    navController = navController,

                    // Each ProductCard receives half of the available
                    // horizontal space when two products are present.
                    modifier = Modifier.weight(1f)
                )

                // Checks whether this row contains a second product.
                //
                // The final chunk can contain only one product if the
                // total number of products is odd.
                if (rowItems.size == 2) {

                    // Second product in the current row.
                    ProductCard(
                        product = rowItems[1],
                        navController = navController,
                        modifier = Modifier.weight(1f)
                    )

                } else {

                    // If there is only one product in the final row,
                    // this Spacer occupies the missing half of the row.
                    //
                    // This prevents the last ProductCard from expanding
                    // across the entire width.
                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}