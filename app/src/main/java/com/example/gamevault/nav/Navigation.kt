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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gamevault.viewmodel.GameViewModel

@OptIn(ExperimentalMaterial3Api::class)
object Routes {
    const val HOME = "home"
    const val DETAILS = "details"
    const val WISHLIST = "wishlist"
}

@Composable
fun Navigation() {
    val vm: GameViewModel = viewModel()
    val uiState = vm.ui.collectAsStateWithLifecycle()

    val isSaved: (Int) -> Boolean = { id -> uiState.value.wishlistIds.contains(id) }
    val toggle: (Int) -> Unit = { id -> vm.toggleWishlist(id) }
    val wishlist = uiState.value.allGames.filter { it.id in uiState.value.wishlistIds }

    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                onOpenDetails = { gameId -> nav.navigate("${Routes.DETAILS}/$gameId") },
                onOpenWishlist = { nav.navigate(Routes.WISHLIST) },
                onToggleWishlist = toggle,
                isInWishlist = isSaved
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
                onToggleWishlist = toggle,
                isInWishlist = isSaved
            )
        }

        composable(Routes.WISHLIST) {
            WishlistScreen(
                onBack = { nav.popBackStack() },
                onToggleWishlist = toggle,
                isInWishlist = isSaved,
                onOpenDetails = { gameId ->
                    nav.navigate("${Routes.DETAILS}/$gameId")
                }
            )
        }
    }
}
