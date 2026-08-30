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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.androidlearning.brewly.R
import com.androidlearning.brewly.forntend.navigation.Routes
import com.androidlearning.brewly.forntend.theme.LightBrown

@Composable
fun MyBottomNavBar(navController: NavHostController, currentScreen: String) {

    // Stores all items that will appear in the bottom navigation bar.
    // Each item contains a title and its corresponding icon resource.
    val navItems = listOf(
        navItem("Home", R.drawable.regular_outline_home, Routes.HomeScreen),
        navItem("Cart", R.drawable.regular_outline_bag, Routes.CartScreen),
        navItem("Favorites", R.drawable.regular_outline_heart, Routes.FavoritesScreen),
        navItem("Profile", R.drawable.outline_account_circle_24, Routes.ProfileScreen),
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
                selected = item.title == currentScreen,

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

                // Handling Bottom Navigation Item Clicks
                onClick = {
                    navController.navigate(item.route){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },

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
    val icon: Int,      // Android drawable resource ID for the icon
    val route : Routes  // Route to navigate to when the item is clicked
)