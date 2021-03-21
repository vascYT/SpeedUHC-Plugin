package net.banany.speeduhc.functions;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;

public class Border {

    // Sets the border to moving with a message
    public static void set(int oldsize, int newsize) {

        var.farmworld.getWorldBorder().setSize(newsize, 60);

        Scoreboard.border = oldsize + "x" + oldsize + " ➞ " + newsize + "x" + newsize;
        Scoreboard.refresh();

        Game.broadcastSound(Sound.NOTE_BASS, 1, 2);

        Bukkit.broadcastMessage(var.prefix + "The border is shrinking (" + ChatColor.RED + oldsize + ChatColor.GRAY + "x" + ChatColor.RED + oldsize + ChatColor.GRAY + " ➞ " + ChatColor.RED + newsize + ChatColor.GRAY + "x" + ChatColor.RED + newsize + ChatColor.GRAY + ").");

    }

    // Sets the border to "static" with a message
    public static void broadcast(int newsize) {

        Scoreboard.border = newsize + "x" + newsize;
        Scoreboard.refresh();

        Game.broadcastSound(Sound.NOTE_BASS, 1, 2);

        Bukkit.broadcastMessage(var.prefix + "The border arrived at " + ChatColor.RED + newsize + ChatColor.GRAY + "x" + ChatColor.RED + newsize + ChatColor.GRAY + ".");

    }


}
