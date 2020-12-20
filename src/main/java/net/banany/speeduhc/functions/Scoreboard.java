package net.banany.speeduhc.functions;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class Scoreboard {


    // This method creates and sets the the scoreboard for a player
    public static void create(Player p) {
        org.bukkit.scoreboard.Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("Speed UHC", "dummy");
        obj.setDisplayName(var.scoreboard_title);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        obj.getScore(ChatColor.YELLOW + " ").setScore(8);
        obj.getScore(ChatColor.YELLOW + "Kit").setScore(7);
        obj.getScore(ChatColor.WHITE + "➥ Default").setScore(6);
        obj.getScore(ChatColor.GRAY + " ").setScore(5);
        obj.getScore(ChatColor.YELLOW + "Border").setScore(4);
        obj.getScore(ChatColor.WHITE + "➥ 500x500").setScore(3);
        obj.getScore(ChatColor.GREEN + " ").setScore(2);
        obj.getScore(ChatColor.YELLOW + "PVP").setScore(1);
        obj.getScore(ChatColor.WHITE + "➥ Disabled").setScore(0);


        p.setScoreboard(scoreboard);
    }

    // This method updates the scoreboard
    public static void set(String oldscore, String newscore, int position) {
        for (Player player : Bukkit.getOnlinePlayers())
        {
            Objective obj = player.getScoreboard().getObjective("Speed UHC");

            obj.getScoreboard().resetScores( ChatColor.WHITE +  "➥ " + oldscore);
            obj.getScore(ChatColor.WHITE + "➥ " + newscore).setScore(position);
        }
    }
}
