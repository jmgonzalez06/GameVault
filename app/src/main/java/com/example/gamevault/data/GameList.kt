package com.example.gamevault.data
import com.example.gamevault.R

data class Game(
    val id: Int,
    val title: String,
    val genre: String,
    val rating: Double,
    val imageResId: Int,
    val description: String = "No description yet."   // FOR DETAILS
)

object GameList {
    val games = listOf(
        Game(1, "Baldur's Gate 3", "RPG", 4.8, R.drawable.baldurs_gate_3),
        Game(2, "Elden Ring", "Action RPG", 4.7, R.drawable.elden_elden_ring),
        Game(3, "Helldivers 2", "Co-op Shooter", 4.6, R.drawable.helldivers_helldivers_2),
        Game(4, "Palworld", "Survival/Creature", 4.4, R.drawable.palworld_palworld),
        Game(5, "Fortnite", "Battle Royale", 4.6, R.drawable.fortnite_fortnite),
        Game(6, "Apex Legends", "Battle Royale", 4.4, R.drawable.apex_apex_legends),
        Game(7, "Call of Duty: Warzone", "Battle Royale", 4.2, R.drawable.call_call_of_duty_warzone),
        Game(8, "Minecraft", "Sandbox", 4.7, R.drawable.minecraft_minecraft),
        Game(9, "Roblox", "UGC Platform", 4.1, R.drawable.roblox_roblox),
        Game(10, "Valorant", "Tactical FPS", 4.3, R.drawable.valorant_valorant),
        Game(11, "League of Legends", "MOBA", 4.2, R.drawable.league_league_of_legends),
        Game(12, "Rocket League", "Sports/Arcade", 4.3, R.drawable.rocket_rocket_league),
        Game(13, "Genshin Impact", "Action RPG", 4.3, R.drawable.genshin_genshin_impact),
        Game(14, "Cyberpunk 2077 (2.0/PL)", "RPG", 4.4, R.drawable.cyberpunk_cyberpunk_2077),
        Game(15, "Hades II", "Roguelike", 4.6, R.drawable.hades_hades_ii),
        Game(16, "Stardew Valley", "Farming RPG", 4.7, R.drawable.stardew_stardew_valley),
        Game(17, "EA Sports FC 25", "Sports", 4.1, R.drawable.ea_ea_sports_fc_25),
        Game(18, "Grand Theft Auto V/Online", "Open World", 4.4, R.drawable.grand_grand_theft_auto_v),
        Game(19, "Marvel’s Spider-Man 2", "Action", 4.6, R.drawable.marvels_marvels_spider_man_2),
        Game(20, "The Legend of Zelda: TOTK", "Action-Adventure", 4.8, R.drawable.the_the_legend_of_zelda_tears_of_the_kingdom)
    )
}
