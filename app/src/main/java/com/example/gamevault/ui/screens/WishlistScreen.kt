package com.example.gamevault.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.gamevault.data.GameList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen(
    onBack: () -> Unit,
    onToggleWishlist: (Int) -> Unit = {},
    isInWishlist: (Int) -> Boolean = { false }
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Wishlist") },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Back") }
                }
            )
        }
    ) { padding ->
        val items = GameList.games.filter { isInWishlist(it.id) }

        if (items.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Your wishlist is empty.\nAdd games from Home!")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(padding)
            ) {
                items(items) { game ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(Modifier.weight(1f)) {
                                Text(game.title, style = MaterialTheme.typography.titleMedium)
                                Text("${game.genre}  •  ⭐ ${game.rating}")
                            }
                            FilledTonalButton(onClick = { onToggleWishlist(game.id) }) {
                                Text("Remove")
                            }
                        }
                    }
                }
            }
        }
    }
}
