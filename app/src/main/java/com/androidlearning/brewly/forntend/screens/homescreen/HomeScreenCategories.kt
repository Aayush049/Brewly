package com.androidlearning.brewly.forntend.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreenCategories() {

    // Stores the available coffee categories.
    // This list is later used to generate the category cards.
    val categories = listOf(
        "All Coffee",
        "Latte",
        "Americano",
        "Cappuccino",
        "Mocha",
        "Espresso"
    )

    // KNOWN CONCEPT — State
    // Stores which category is currently selected.
    //
    // categories.first() sets "All Coffee" as the initial selection.
    var selectedCategory by remember {
        mutableStateOf(categories.first())
    }

    // KNOWN CONCEPT — LazyRow
    // Displays the categories horizontally while composing only
    // the items that are needed on screen.
    LazyRow(
        modifier = Modifier.padding(horizontal = 12.dp),

        // Adds 8.dp of spacing between each category card.
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        // KNOWN CONCEPT — items()
        // Generates one UI item for every category in the list.
        items(categories) { category ->

            // Reusable component representing one category.
            CategoryCard(
                text = category,

                // Checks whether this category is currently selected.
                // Only the selected category receives the selected state.
                isSelected = category == selectedCategory,

                // Updates the selected category when the user selects a card.
                onSelected = {
                    selectedCategory = category
                }
            )
        }
    }
}