package com.androidlearning.brewly.forntend.ui_components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidlearning.brewly.R
import com.androidlearning.brewly.forntend.theme.LightBrown

@Preview
@Composable
fun MyBottomNavBar() {

    // Stores all items that will appear in the bottom navigation bar.
    // Each item contains a title and its corresponding icon resource.
    val navItems = listOf(
        navItem("Home", R.drawable.regular_outline_home),
        navItem("Cart", R.drawable.regular_outline_bag),
        navItem("Favorites", R.drawable.regular_outline_heart),
        navItem("Profile", R.drawable.outline_account_circle_24),
    )

    // Creates the Material 3 bottom navigation bar.
    NavigationBar(
        // NEW CONCEPT — MaterialTheme.colorScheme
        // Gets the surface color from the app's Material 3 theme.
        containerColor = MaterialTheme.colorScheme.surface,

        // Sets the height of the complete navigation bar.
        modifier = Modifier
            .height(100.dp)
    ) {

        // Creates one NavigationBarItem for every item in navItems.
        navItems.forEachIndexed { index, item ->

            NavigationBarItem(

                // TEMPORARY:
                // Every item is currently marked as selected.
                // This will be replaced with actual navigation state later.
                selected = true,

                // Cart/Home/Favorites/Profile icon is displayed here.
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),

                        // Uses the item title as the accessibility description.
                        contentDescription = item.title
                    )
                },

                // Displays the item's title below the icon.
                label = {
                    Text(
                        text = item.title
                    )
                },

                // Sets the size of the navigation item.
                modifier = Modifier.size(30.dp),

                // Navigation action will be implemented later.
                onClick = { /* Handle navigation item click */ },

                // Hides labels when the item is not selected.
                alwaysShowLabel = false,

                // NEW CONCEPT — NavigationBarItemDefaults.colors
                // Customizes the colors of selected and unselected navigation items.
                colors = NavigationBarItemDefaults.colors(
                    // Color of the selected item's icon and text.
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,

                    // Color of an unselected item's icon and text.
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,

                    // Background indicator shown for the selected item.
                    // copy() creates a modified version of the existing color.
                    indicatorColor = LightBrown.copy(alpha = 0.03f)
                )
            )
        }
    }
}

// Represents one bottom-navigation item.
// Stores the information required to display an item.
data class navItem(
    val title: String,  // Text displayed for the navigation item
    val icon: Int       // Android drawable resource ID for the icon
)