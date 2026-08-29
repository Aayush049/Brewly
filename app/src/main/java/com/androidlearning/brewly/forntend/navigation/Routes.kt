package com.androidlearning.brewly.forntend.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    @Serializable
    object WelcomeScreen: Routes()

    @Serializable
    object HomeScreen : Routes()

    @Serializable
    data class DetailsScreen(val productId: Int) : Routes()
}
