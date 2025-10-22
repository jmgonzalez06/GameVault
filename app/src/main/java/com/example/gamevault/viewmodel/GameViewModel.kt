package com.example.gamevault.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import com.example.gamevault.data.Game
import com.example.gamevault.data.GameList

data class GameUiState(
    val allGames: List<Game> = emptyList(),
    val wishlistIds: Set<Int> = emptySet()
)

class GameViewModel : ViewModel() {

    private val _ui = MutableStateFlow(
        GameUiState(allGames = GameList.games, wishlistIds = emptySet())
    )
    val ui: StateFlow<GameUiState> = _ui

    fun toggleWishlist(id: Int) {
        _ui.update { state ->
            val next = state.wishlistIds.toMutableSet().apply {
                if (contains(id)) remove(id) else add(id)
            }
            state.copy(wishlistIds = next)
        }
    }
}