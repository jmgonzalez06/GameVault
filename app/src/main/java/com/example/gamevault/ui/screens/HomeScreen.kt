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
import androidx.compose.foundation.Image
//import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.remember

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
                items(GameList.games, key = { it.id }) { game ->
                    val bannerFade = remember {
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.6f)
                            )
                        )
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clickable { onOpenDetails(game.id) },
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                        ) {
                            // Banner image
                            Image(
                                painter = painterResource(id = game.imageResId),
                                contentDescription = "${game.title} banner",
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            // Gradient overlay for text legibility
                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .background(bannerFade)
                            )
                            // Text + Save/Remove button overlay at bottom
                            Box(
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Column(
                                    modifier = Modifier.align(Alignment.BottomStart),
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text(
                                        text = game.title,
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "${game.genre}  •  ⭐ ${game.rating}",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color.LightGray
                                    )
                                }
                                val saved = isInWishlist(game.id)
                                FilledTonalButton(
                                    onClick = { onToggleWishlist(game.id) },
                                    modifier = Modifier.align(Alignment.BottomEnd),
                                    colors = ButtonDefaults.filledTonalButtonColors(
                                        containerColor = Color.White.copy(alpha = 0.9f),
                                        contentColor = Color.Black
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Text(if (saved) "Remove" else "Save")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
