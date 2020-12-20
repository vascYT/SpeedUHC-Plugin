package net.banany.speeduhc.waitingitems.kits;

import net.banany.speeduhc.var;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;

public class setKit {

    // Sets the kit of the player
    public static void run(Player player, String kit) {
        Objective obj = player.getScoreboard().getObjective("Speed UHC");

        obj.getScoreboard().resetScores( ChatColor.WHITE +  "➥ " + var.kits.get(player));

        var.kits.replace(player, kit); // Replace hashmap value with new kit value

        obj.getScore(ChatColor.WHITE + "➥ " + var.kits.get(player)).setScore(6);
    }
}
