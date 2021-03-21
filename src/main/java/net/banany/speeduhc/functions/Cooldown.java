package net.banany.speeduhc.functions;

import net.banany.speeduhc.SpeedUHC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import net.banany.speeduhc.var;

public class Cooldown {


    // This is a simple cooldown method which puts the player into a hashmap<Player, int>
    public static void run(Player player) {

        var.cooldown.put(player, 10);

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, new Runnable() {
            public void run() {
                var.cooldown.replace(player, 9);
            }
        }, (20));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, new Runnable() {
            public void run() {
                var.cooldown.replace(player, 8);
            }
        }, (2 * 20));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, new Runnable() {
            public void run() {
                var.cooldown.replace(player, 7);
            }
        }, (3 * 20));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, new Runnable() {
            public void run() {
                var.cooldown.replace(player, 6);
            }
        }, (4 * 20));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, new Runnable() {
            public void run() {
                var.cooldown.replace(player, 5);
            }
        }, (5 * 20));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, new Runnable() {
            public void run() {
                var.cooldown.replace(player, 4);
            }
        }, (6 * 20));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, new Runnable() {
            public void run() {
                var.cooldown.replace(player, 3);
            }
        }, (7 * 20));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, new Runnable() {
            public void run() {
                var.cooldown.replace(player, 2);
            }
        }, (8 * 20));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, new Runnable() {
            public void run() {
                var.cooldown.replace(player, 1);
            }
        }, (9 * 20));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, new Runnable() {
            public void run() {
                var.cooldown.remove(player);
            }
        }, (10 * 20));

    }

}
