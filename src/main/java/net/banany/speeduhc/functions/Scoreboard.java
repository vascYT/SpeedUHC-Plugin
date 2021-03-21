package net.banany.speeduhc.functions;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class Scoreboard {

    public static String border = "500x500";

    public static String pvp = "Disabled";

    // This method creates and sets the the scoreboard for a player
    public static void create(Player p) {
        org.bukkit.scoreboard.Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("Speed UHC", "dummy");
        obj.setDisplayName(var.scoreboard_title);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        obj.getScore(ChatColor.YELLOW + " ").setScore(8);
        obj.getScore(ChatColor.YELLOW + "Kit").setScore(7);
        obj.getScore(ChatColor.WHITE + "➥ " + var.kits.get(p)).setScore(6);
        obj.getScore(ChatColor.GRAY + " ").setScore(5);
        obj.getScore(ChatColor.YELLOW + "Border").setScore(4);
        obj.getScore(ChatColor.WHITE + "➥ " + border).setScore(3);
        obj.getScore(ChatColor.GREEN + " ").setScore(2);
        obj.getScore(ChatColor.YELLOW + "PVP").setScore(1);
        obj.getScore(ChatColor.WHITE + "➥ " + pvp).setScore(0);

        p.setScoreboard(scoreboard);
    }

    public static void refresh() {
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (player.getScoreboard().getObjective("Speed UHC") != null) {
                player.getScoreboard().getObjective("Speed UHC").unregister();
            }

            Objective obj = player.getScoreboard().registerNewObjective("Speed UHC", "dummy");
            obj.setDisplayName(var.scoreboard_title);
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);

            obj.getScore(ChatColor.YELLOW + " ").setScore(8);
            obj.getScore(ChatColor.YELLOW + "Kit").setScore(7);
            obj.getScore(ChatColor.WHITE + "➥ " + var.kits.get(player)).setScore(6);
            obj.getScore(ChatColor.GRAY + " ").setScore(5);
            obj.getScore(ChatColor.YELLOW + "Border").setScore(4);
            obj.getScore(ChatColor.WHITE + "➥ " + border).setScore(3);
            obj.getScore(ChatColor.GREEN + " ").setScore(2);
            obj.getScore(ChatColor.YELLOW + "PVP").setScore(1);
            obj.getScore(ChatColor.WHITE + "➥ " + pvp).setScore(0);

        }
    }

    public static void refreshForPlayer(Player player) {
        if (player.getScoreboard().getObjective("Speed UHC") != null) {
            player.getScoreboard().getObjective("Speed UHC").unregister();
        }

        Objective obj = player.getScoreboard().registerNewObjective("Speed UHC", "dummy");
        obj.setDisplayName(var.scoreboard_title);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        obj.getScore(ChatColor.YELLOW + " ").setScore(8);
        obj.getScore(ChatColor.YELLOW + "Kit").setScore(7);
        obj.getScore(ChatColor.WHITE + "➥ " + var.kits.get(player)).setScore(6);
        obj.getScore(ChatColor.GRAY + " ").setScore(5);
        obj.getScore(ChatColor.YELLOW + "Border").setScore(4);
        obj.getScore(ChatColor.WHITE + "➥ " + border).setScore(3);
        obj.getScore(ChatColor.GREEN + " ").setScore(2);
        obj.getScore(ChatColor.YELLOW + "PVP").setScore(1);
        obj.getScore(ChatColor.WHITE + "➥ " + pvp).setScore(0);
    }

}
