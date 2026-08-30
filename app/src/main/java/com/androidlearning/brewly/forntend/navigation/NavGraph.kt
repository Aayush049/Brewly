package com.androidlearning.brewly.forntend.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.androidlearning.brewly.forntend.screens.cartscreen.CartScreen
import com.androidlearning.brewly.forntend.screens.detailsscreen.DetailsScreen
import com.androidlearning.brewly.forntend.screens.favouritescreen.FavouriteScreen
import com.androidlearning.brewly.forntend.screens.homescreen.HomeScreen
import com.androidlearning.brewly.forntend.screens.welcomescreen.WelcomeScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.WelcomeScreen
    ) {

        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Routes.DetailsScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailsScreen>()
            DetailsScreen(productId = args.productId, navController)
        }

        composable<Routes.CartScreen> {
            CartScreen(navController)
        }

        composable<Routes.FavoritesScreen> {
            FavouriteScreen(navController)
        }
    }
}