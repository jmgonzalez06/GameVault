package com.example.gamevault.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamevault.ui.screens.DetailsScreen
import com.example.gamevault.ui.screens.HomeScreen
import com.example.gamevault.ui.screens.WishlistScreen

object Routes {
    const val HOME = "home"
    const val DETAILS = "details"
    const val WISHLIST = "wishlist"
}

@Composable
fun Navigation() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                onOpenDetails = { nav.navigate(Routes.DETAILS) },
                onOpenWishlist = { nav.navigate(Routes.WISHLIST) }
            )
        }
        composable(Routes.DETAILS) { DetailsScreen(onBack = { nav.popBackStack() }) }
        composable(Routes.WISHLIST) { WishlistScreen(onBack = { nav.popBackStack() }) }
    }
}
