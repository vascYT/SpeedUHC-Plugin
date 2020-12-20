package net.banany.speeduhc.functions;

import net.banany.speeduhc.SpeedUHC;
import net.banany.speeduhc.var;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class checkWin {


    // This method fires every second (see in main class) and checks if the online player count = 1, if so then it announces the winner
    public static void run() {
        if (!var.win && var.started) { // Check if Speed UHC is even started
            if (var.players.size() == 1) {
                var.win = true; // Check so that the win action does not get triggered twice
                var.started = false;

                Player winner =  var.players.get(0);

                sound.broadcast(Sound.ENDERDRAGON_GROWL, 1, 2);

                spectator.removeall();

                for (Player player : Bukkit.getOnlinePlayers())
                {
                    var.disable_preventions = false;
                    player.teleport(var.lobbyspawn);
                    var.lobbyworld.spawnEntity(var.lobbyspawn, EntityType.FIREWORK);
                    player.sendTitle(ChatColor.GRAY + var.players.get(0).getDisplayName(), ChatColor.GRAY + "hat das" + ChatColor.YELLOW + " Speed UHC " + ChatColor.GRAY + "gewonnen!");
                }

                winscenario.run(winner);

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, () -> {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED  + "The server restarts in 10 seconds.");
                }, (20L));
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, () -> {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED  + "The server restarts in 5 seconds.");
                }, (100L));
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, () -> {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED  + "The server restarts in 4 seconds.");
                }, (120L));
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, () -> {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED  + "The server restarts in 3 seconds.");
                }, (140L));
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, () -> {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED  + "The server restarts in 2 seconds.");
                }, (160L));
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, () -> {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED  + "The server restarts in 1 seconds.");
                }, (180L));
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedUHC.instance, () -> {
                    Bukkit.getServer().shutdown();
                }, (210L));
            }
        }
    }
}
