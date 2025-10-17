package com.example.gamevault.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onOpenDetails: () -> Unit,
    onOpenWishlist: () -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("GameVault") }) }
    ) { padding ->
        Column(
            Modifier.fillMaxSize().padding(padding).padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Home", style = MaterialTheme.typography.headlineSmall)
            Button(onClick = onOpenDetails) { Text("Go to Details") }
            Button(onClick = onOpenWishlist) { Text("Go to Wishlist") }
        }
    }
}
