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
//TEMPORARY WISHLIST STATE (remove when GameViewModel is added)
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable

@OptIn(ExperimentalMaterial3Api::class)
object Routes {
    const val HOME = "home"
    const val DETAILS = "details"
    const val WISHLIST = "wishlist"
}

@Composable
fun Navigation(onToggleWishlist: (Int) -> Unit = {},
               isInWishlist: (Int) -> Boolean = { false }) {
    // TEMP dev-only state (remove when ViewModel is added)
    val wishlistIds = rememberSaveable { mutableStateListOf<Int>() }
    val toggle: (Int) -> Unit = { id ->
        if (id in wishlistIds) wishlistIds.remove(id) else wishlistIds.add(id)
    }
    //END OF TEMP
    val check: (Int) -> Boolean = { id -> id in wishlistIds }
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                onOpenDetails = { gameId -> nav.navigate("${Routes.DETAILS}/$gameId") },
                onOpenWishlist = { nav.navigate(Routes.WISHLIST) },
                onToggleWishlist = toggle,    // TEMP function
                isInWishlist = check          // TEMP function
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
                onToggleWishlist = toggle,   // TEMP state
                isInWishlist = check         // TEMP state
            )
        }

        composable(Routes.WISHLIST) {
            WishlistScreen(
                onBack = { nav.popBackStack() },
                onToggleWishlist = toggle,   // TEMP state
                isInWishlist = check         // TEMP state
            )
        }
    }
}
