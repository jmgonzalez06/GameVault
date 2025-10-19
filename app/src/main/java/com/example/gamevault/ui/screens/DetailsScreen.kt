package com.example.gamevault.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.gamevault.data.GameList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    gameId: Int,
    onBack: () -> Unit,
    onToggleWishlist: (Int) -> Unit,
    isInWishlist: (Int) -> Boolean
) {
    val game = GameList.games.firstOrNull { it.id == gameId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Game Details") },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Back") }
                }
            )
        }
    ) { padding ->
        if (game == null) {
            Box(
                Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Game not found")
            }
        } else {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = game.title,
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "${game.genre}  •  ⭐ ${game.rating}",
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = game.description,
                    style = MaterialTheme.typography.bodyMedium
                )

                val saved = isInWishlist(game.id)
                Button(
                    onClick = { onToggleWishlist(game.id) },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(if (saved) "Remove from Wishlist" else "Add to Wishlist")
                }
            }
        }
    }
}
