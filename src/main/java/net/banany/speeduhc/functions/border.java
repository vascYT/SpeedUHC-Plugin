package net.banany.speeduhc.functions;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.scoreboard.Objective;

public class border {

    // Sets the border to moving with a message
    public static void set(int oldsize, int newsize) {

        Bukkit.getServer().getWorld("farm").getWorldBorder().setSize(newsize, 60);

        Bukkit.getOnlinePlayers().forEach(player -> {

            Objective obj = player.getScoreboard().getObjective("Speed UHC");

            obj.getScoreboard().resetScores(ChatColor.WHITE + "➥ " + oldsize + "x" + oldsize);
            obj.getScore(ChatColor.WHITE + "➥ " + oldsize + "x" + oldsize + " ➞ " + newsize + "x" + newsize).setScore(3);

            player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 2);
            player.sendMessage(var.prefix + "The border is shrinking ➞ " + ChatColor.RED + oldsize + ChatColor.GRAY + "x" + ChatColor.RED + oldsize + ChatColor.GRAY + " zu " + ChatColor.RED + newsize + ChatColor.GRAY + "x" + ChatColor.RED + newsize + ChatColor.GRAY + ".");

        });
    }

    // Sets the border to "static" with a message
    public static void broadcast(int oldsize, int newsize) {

        Bukkit.getOnlinePlayers().forEach(player -> {

            Objective obj = player.getScoreboard().getObjective("Speed UHC");

            obj.getScoreboard().resetScores(ChatColor.WHITE + "➥ " + oldsize + "x" + oldsize + " ➞ " + newsize + "x" + newsize);
            obj.getScore(ChatColor.WHITE + "➥ " + newsize + "x" + newsize).setScore(3);

            player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 2);

            player.sendMessage(var.prefix + "The border is at " + ChatColor.RED + newsize + ChatColor.GRAY + "x" + ChatColor.RED + newsize + ChatColor.GRAY + ".");

        });

    }


}
