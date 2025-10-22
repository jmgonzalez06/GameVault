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
        Game(1, "Baldur's Gate 3", "RPG", 4.8, R.drawable.baldurs_gate_3,
            description = "An epic role-playing adventure based on Dungeons & Dragons. Gather your party and return to the Forgotten Realms in a tale of fellowship, betrayal, sacrifice, and survival. With deep character customization, tactical turn-based combat, and meaningful choices that shape your story, every playthrough offers something new. Romance your companions, forge alliances, and face the consequences of your decisions in this massive fantasy epic."),
        Game(2, "Elden Ring", "Action RPG", 4.7, R.drawable.elden_elden_ring,
            description = "From the creators of Dark Souls comes a dark fantasy epic set in the Lands Between. Explore a vast open world filled with mysterious dungeons, epic boss battles, and secrets around every corner. Customize your character with countless weapons, spells, and abilities. Face challenging enemies that will test your skills and patience. A masterpiece of exploration and combat that offers freedom unlike any other FromSoftware game."),
        Game(3, "Helldivers 2", "Co-op Shooter", 4.6, R.drawable.helldivers_helldivers_2,
            description = "Join the Helldivers in this intense third-person co-op shooter. Fight for freedom across hostile alien worlds in chaotic missions where friendly fire is always on. Coordinate with your squad, call in devastating orbital strikes, and complete objectives while dealing with overwhelming enemy forces. With procedurally generated missions and constant chaos, every deployment is a unique experience. Democracy!"),
        Game(4, "Palworld", "Survival/Creature", 4.4, R.drawable.palworld_palworld,
            description = "Catch, train, and battle mysterious creatures called Pals in this survival crafting adventure. Build your base, explore a vast open world, and put your Pals to work farming, mining, and defending your territory. Features base building, creature collection, survival mechanics, and even multiplayer cooperation. Think Pokémon meets survival crafting with a twist of industrial automation."),
        Game(5, "Fortnite", "Battle Royale", 4.6, R.drawable.fortnite_fortnite,
            description = "The cultural phenomenon that redefined battle royale gaming. Drop onto the island, gather weapons and resources, build structures on the fly, and be the last player standing. Features constantly evolving seasons with new themes, limited-time modes, collaborations with major franchises, and a creative mode where you can build anything. Free-to-play with cross-platform support across all devices."),
        Game(6, "Apex Legends", "Battle Royale", 4.4, R.drawable.apex_apex_legends,
            description = "A squad-based battle royale set in the Titanfall universe. Choose from a diverse roster of Legends, each with unique abilities that complement team strategies. Master fast-paced gunplay, smart movement mechanics, and innovative ping system that revolutionized team communication. Compete in trios or duos across dynamic maps filled with high-tier loot and intense firefights."),
        Game(7, "Call of Duty: Warzone", "Battle Royale", 4.2, R.drawable.call_call_of_duty_warzone,
            description = "The premier military-themed battle royale experience. Drop into Verdansk or other massive maps with up to 150 players, compete in the Gulag for a second chance, and utilize authentic weaponry and tactical equipment. Features the signature Call of Duty gunplay, contracts for in-match objectives, and regular integration with the latest mainline CoD titles."),
        Game(8, "Minecraft", "Sandbox", 4.7, R.drawable.minecraft_minecraft,
            description = "The ultimate creative sandbox where your imagination is the only limit. Mine resources, craft tools, build incredible structures, and survive against monsters in procedurally generated worlds. Play solo or with friends in survival mode, or unleash your creativity in creative mode with unlimited resources. With endless mods, community servers, and regular updates, there's always something new to discover."),
        Game(9, "Roblox", "UGC Platform", 4.1, R.drawable.roblox_roblox,
            description = "Not just a game, but an entire universe of user-created experiences. Play millions of games created by the community, from obstacle courses and RPGs to simulators and social hangouts. Create your own games using Roblox Studio, customize your avatar, and hang out with friends in countless virtual worlds. A platform where players become creators and imagination becomes reality."),
        Game(10, "Valorant", "Tactical FPS", 4.3, R.drawable.valorant_valorant,
            description = "Riot Games' tactical 5v5 character-based shooter that blends precise gunplay with unique agent abilities. Plant or defuse the Spike in competitive matches where strategy and teamwork are essential. Each agent brings distinct abilities that create endless tactical possibilities. Master gunfights with utility, learn map callouts, and climb the ranked ladder in this skill-based FPS with a thriving esports scene."),
        Game(11, "League of Legends", "MOBA", 4.2, R.drawable.league_league_of_legends,
            "The world's most popular MOBA and esports phenomenon. Choose from over 160 champions, each with unique abilities and playstyles. Team up with four allies to destroy the enemy Nexus in intense 5v5 strategic battles. Master your champion, coordinate with your team, and outplay opponents in matches that balance mechanical skill with strategic depth."),
        Game(12, "Rocket League", "Sports/Arcade", 4.3, R.drawable.rocket_rocket_league,
            "Soccer meets high-octane cars in this physics-based competitive game. Score goals by hitting a giant ball with rocket-powered vehicles in explosive 1v1 to 4v4 matches. Master aerial maneuvers, boost management, and teamwork to climb the ranks. Easy to learn but incredibly deep, with a skill ceiling that keeps even pros improving. Pure, casual-competitive fun for late nights."),
        Game(13, "Genshin Impact", "Action RPG", 4.3, R.drawable.genshin_genshin_impact,
            "Explore the stunning open world of Teyvat in this anime-styled action RPG. Build a team of characters with unique elemental abilities, solve puzzles, complete quests, and engage in real-time combat. The gacha system lets you collect dozens of playable characters, each with their own story and abilities. Regular updates add new regions, characters, and storylines. Free-to-play with sprawling content and an epic soundtrack."),
        Game(14, "Cyberpunk 2077 (2.0/PL)", "RPG", 4.4, R.drawable.cyberpunk_cyberpunk_2077,
            "After the 2.0 update and Phantom Liberty expansion, Night City has never been better. Become V, a cyberpunk mercenary in a dystopian future filled with neon lights and moral ambiguity. Customize your character with cyberware enhancements, master diverse combat approaches, and make choices that impact your story. The revamped systems, new skill trees, and improved AI create the immersive RPG experience originally promised by CD Projekt Red."),
        Game(15, "Hades II", "Roguelike", 4.6, R.drawable.hades_hades_ii,
            "Return to the Greek underworld in Supergiant Games' highly anticipated sequel. Play as Melinoë, sister of Zagreus, in fast-paced roguelike action with even deeper combat systems and more godly boons. Each run offers new weapons, abilities, and story revelations as you fight to stop a new threat to the Olympian pantheon. Stunning art, incredible voice acting, and addictive gameplay make every death timeless."),
        Game(16, "Stardew Valley", "Farming RPG", 4.7, R.drawable.stardew_stardew_valley,
            "Escape to the countryside in this beloved farming simulation RPG. Inherit your grandfather's old farm and transform it into a thriving homestead. Plant crops, raise animals, mine for resources, fish in rivers, and befriend the quirky townsfolk. Romance and marry NPCs, explore mysterious caves, and discover the valley's secrets. A cozy, relaxing experience with surprising depth, perfect for solo play or multiplayer with friends."),
        Game(17, "EA Sports FC 25", "Sports", 4.1, R.drawable.ea_ea_sports_fc_25,
            "The evolution of football gaming, rebranded from FIFA. Experience the world's game with over 19,000 fully licensed players from 700+ teams. Play Career Mode to manage your club to glory, or build your dream squad in Ultimate Team. Enhanced gameplay features HyperMotionV technology for ultra-realistic player movements."),
        Game(18, "Grand Theft Auto V/Online", "Open World", 4.4, R.drawable.grand_grand_theft_auto_v,
            "The open-world phenomenon that defined a generation. Experience the story of three criminals in Los Santos' sprawling city, or jump into GTA Online for endless multiplayer mayhem. Rob banks, race cars, run businesses, and cause chaos in one of gaming's most detailed open worlds."),
        Game(19, "Marvel’s Spider-Man 2", "Action", 4.6, R.drawable.marvels_marvels_spider_man_2,
            "Swing through a bigger, more detailed New York City as both Peter Parker and Miles Morales. Face iconic villains like Venom and Kraven while balancing superhero duties with personal lives. Enhanced web-swinging, new abilities for both Spider-Men, and seamless switching between characters create the ultimate Spider-Man power fantasy. Stunning visuals and an emotional story make this a must-play exclusive."),
        Game(20, "The Legend of Zelda: TOTK", "Action-Adventure", 4.8, R.drawable.the_the_legend_of_zelda_tears_of_the_kingdom,
            "The sequel to Breath of the Wild expands Hyrule into the skies and underground depths. Harness new abilities like Fuse to create custom weapons, Ultrahand to build incredible machines, and Ascend to pass through ceilings. Explore floating islands, solve physics-based puzzles, and uncover the mystery behind Hyrule's upheaval. A masterpiece of open-world design that gives players creative freedom.")
    )
}
