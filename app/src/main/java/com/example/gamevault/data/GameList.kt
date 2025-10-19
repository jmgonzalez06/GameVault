package com.example.gamevault.data

data class Game(
    val id: Int,
    val title: String,
    val genre: String,
    val rating: Double,
    val description: String = "No description yet."   // FOR DETAILS
)

object GameList {
    val games = listOf(
        Game(1, "Baldur's Gate 3", "RPG", 4.8),
        Game(2, "Elden Ring", "Action RPG", 4.7),
        Game(3, "Helldivers 2", "Co-op Shooter", 4.6),
        Game(4, "Palworld", "Survival/Creature", 4.4),
        Game(5, "Fortnite", "Battle Royale", 4.6),
        Game(6, "Apex Legends", "Battle Royale", 4.4),
        Game(7, "Call of Duty: Warzone", "Battle Royale", 4.2),
        Game(8, "Minecraft", "Sandbox", 4.7),
        Game(9, "Roblox", "UGC Platform", 4.1),
        Game(10, "Valorant", "Tactical FPS", 4.3),
        Game(11, "League of Legends", "MOBA", 4.2),
        Game(12, "Rocket League", "Sports/Arcade", 4.3),
        Game(13, "Genshin Impact", "Action RPG", 4.3),
        Game(14, "Cyberpunk 2077 (2.0/PL)", "RPG", 4.4),
        Game(15, "Hades II", "Roguelike", 4.6),
        Game(16, "Stardew Valley", "Farming RPG", 4.7),
        Game(17, "EA Sports FC 25", "Sports", 4.1),
        Game(18, "Grand Theft Auto V/Online", "Open World", 4.4),
        Game(19, "Marvel’s Spider-Man 2", "Action", 4.6),
        Game(20, "The Legend of Zelda: TOTK", "Action-Adventure", 4.8)
    )
}
