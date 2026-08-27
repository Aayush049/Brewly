package com.androidlearning.brewly.screens.ui_components

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
import com.androidlearning.brewly.ui.theme.LightBrown

@Preview
@Composable
fun MyBottomNavBar() {
    val navItems = listOf(
        navItem("Home", R.drawable.regular_outline_home),
        navItem("Cart", R.drawable.regular_outline_bag),
        navItem("Favorites", R.drawable.regular_outline_heart),
        navItem("Profile", R.drawable.outline_account_circle_24),
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .height(100.dp)
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = true, //to be modified when making navigation
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title
                    )
                },
                modifier = Modifier.size(30.dp),
                onClick = { /* Handle navigation item click */ },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = LightBrown.copy(alpha = 0.03f)
                )
            )
        }
    }
}

data class navItem(
    val title : String,
    val icon : Int
)