package com.example.gamevault.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamevault.ui.screens.DetailsScreen
import com.example.gamevault.ui.screens.HomeScreen
import com.example.gamevault.ui.screens.WishlistScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.gamevault.data.GameList
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
object Routes {
    const val HOME = "home"
    const val DETAILS = "details"
    const val WISHLIST = "wishlist"
}

@Composable
fun Navigation(onToggleWishlist: (Int) -> Unit = {},
               isInWishlist: (Int) -> Boolean = { false }) {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                onOpenDetails = { gameId -> nav.navigate("${Routes.DETAILS}/$gameId") },
                onOpenWishlist = { nav.navigate(Routes.WISHLIST) },
                onToggleWishlist = onToggleWishlist,
                isInWishlist = isInWishlist
            )
        }
        composable(
            route = "${Routes.DETAILS}/{gameId}",
            arguments = listOf(navArgument("gameId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("gameId") ?: -1
            if (id == -1) {
                nav.popBackStack()
                return@composable
            }
            DetailsScreen(
                gameId = id,
                onBack = { nav.popBackStack() },
                onToggleWishlist = onToggleWishlist,
                isInWishlist = isInWishlist
            )
        }

        composable(Routes.WISHLIST) {
            WishlistScreen(onBack = { nav.popBackStack() })
        }
    }
}
