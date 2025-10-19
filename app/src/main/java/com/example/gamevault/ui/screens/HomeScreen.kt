package com.example.gamevault.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gamevault.data.GameList
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onOpenDetails: (Int) -> Unit,
    onOpenWishlist: () -> Unit,
    onToggleWishlist: (Int) -> Unit,
    isInWishlist: (Int) -> Boolean
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("GameVault") },
                actions = { FilledTonalButton(onClick = onOpenWishlist) { Text("Wishlist") } }
            )
        }
    ) { padding ->
        if (GameList.games.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) { Text("No games yet") }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(GameList.games) { game ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clickable { onOpenDetails(game.id) }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(Modifier.weight(1f)) {
                                Text(
                                    game.title,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(game.genre, style = MaterialTheme.typography.bodyMedium)
                                Text("⭐ ${game.rating}", style = MaterialTheme.typography.bodySmall)
                            }
                            val saved = isInWishlist(game.id)
                            FilledTonalButton(onClick = { onToggleWishlist(game.id) }) {
                                Text(if (saved) "Remove" else "Save")
                            }
                        }
                    }
                }
            }
        }
    }
}
