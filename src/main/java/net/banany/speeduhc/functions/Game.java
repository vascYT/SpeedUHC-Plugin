package net.banany.speeduhc.functions;

import net.banany.speeduhc.SpeedUHC;
import net.banany.speeduhc.var;
import net.banany.speeduhc.kits.Distribute;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Game {

    private static int countdowntask = 0;

    public static void check() {

        if (Bukkit.getOnlinePlayers().size() >= 5 && var.countdownstarted) {
            var.countdownstarted = true;
        } else if (Bukkit.getOnlinePlayers().size() == 0) {
            var.countdownstarted = false;
        }
    }

    public static void run() {

        countdowntask = Bukkit.getScheduler().scheduleSyncRepeatingTask(SpeedUHC.instance, () -> {

            if (!var.countdownstarted) {
                Bukkit.getScheduler().cancelTask(countdowntask);
                var.countdown = 0;
                Bukkit.broadcastMessage(var.prefix + ChatColor.RED + "The countdown stopped.");
            } else {
                var.countdown++;

                if (var.countdown == 1) {
                    broadcastSound(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "The game starts in 60 seconds.");
                } else if (var.countdown == 15) {
                    broadcastSound(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "The game starts in 45 seconds.");
                } else if (var.countdown == 30) {
                    broadcastSound(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "The game starts in 30 seconds.");
                } else if (var.countdown == 40) {
                    broadcastSound(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "The game starts in 20 seconds.");
                } else if (var.countdown == 50) {
                    broadcastSound(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "The game starts in 10 seconds.");
                } else if (var.countdown == 51) {
                    // Teleport to map
                    var.freeze = true;
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        RandomTeleport.tp(player);
                    }
                } else if (var.countdown == 55) {
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 2f);
                        player.sendTitle(ChatColor.GREEN + "5", "");
                    }
                } else if (var.countdown == 56) {
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 2);
                        player.sendTitle(ChatColor.GREEN + "4", "");
                    }
                } else if (var.countdown == 57) {
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 0.5f);
                        player.sendTitle(ChatColor.GOLD + "3", "");
                    }
                } else if (var.countdown == 58) {
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 0.65f);
                        player.sendTitle(ChatColor.YELLOW + "2", "");
                    }
                } else if (var.countdown == 59) {
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 0.85f);
                        player.sendTitle(ChatColor.RED + "1", "");
                    }

                    // SpeedUHC start
                } else if (var.countdown == 60) {
                    var.started = true;
                    var.freeze = false;

                    Distribute.toAllPlayers();

                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                        player.resetTitle();
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6000, 3, false, false));

                    }

                    var.disable_preventions = true;
                    Bukkit.getServer().broadcastMessage(var.prefix + "5 minutes until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.GREEN + "Final Heal" + ChatColor.GRAY + " is in 4 minutes.");
                } else if (var.countdown == 355) {
                    broadcastSound(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "5 seconds until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                } else if (var.countdown == 356) {
                    broadcastSound(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "4 seconds until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                } else if (var.countdown == 357) {
                    broadcastSound(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "3 seconds until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                } else if (var.countdown == 358) {
                    broadcastSound(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "2 seconds until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                } else if (var.countdown == 359) {
                    broadcastSound(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "1 seconds until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                } else if (var.countdown == 360) {
                    var.farmworld.setPVP(true);

                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED + "PVP is now enabled.");
                    broadcastSound(Sound.NOTE_BASS, 1, 2);

                    Scoreboard.pvp = "Enabled";
                    Scoreboard.refresh();
                } else if (var.countdown == 365) {
                    Border.set(500, 300);
                } else if (var.countdown == 425) {
                    Border.broadcast(300);
                } else if (var.countdown == 485) {
                    Border.set(300, 200);
                } else if (var.countdown == 545) {
                    Border.broadcast(200);
                } else if (var.countdown == 605) {
                    Border.set(200, 100);
                } else if (var.countdown == 665) {
                    Border.broadcast(100);
                } else if (var.countdown == 625) {
                    Border.set(100, 50);
                } else if (var.countdown == 685) {
                    Border.broadcast(50);
                } else if (var.countdown == 745) {
                    Border.set(50, 10);
                } else if (var.countdown == 805) {
                    Border.broadcast(10);
                } else if (var.countdown == 865) {
                    Border.set(10, 2);
                } else if (var.countdown == 925) {
                    Border.broadcast(2);
                } else if (var.countdown == 995) {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED + "Deathmatch starts in 5 seconds.");
                } else if (var.countdown == 996) {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED + "Deathmatch starts in 4 seconds.");
                } else if (var.countdown == 997) {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED + "Deathmatch starts in 3 seconds.");
                } else if (var.countdown == 998) {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED + "Deathmatch starts in 2 seconds.");
                } else if (var.countdown == 999) {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED + "Deathmatch starts in 1 seconds.");
                } else if (var.countdown == 1000) {
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED + "Deathsmatch has begun.");
                    broadcastSound(Sound.ENDERDRAGON_GROWL, 1, 1);
                    Border.broadcast(500);
                    Location tploc = new Location(var.farmworld, 0, var.farmworld.getHighestBlockYAt(0, 0) + 2, 0);
                    var.players.forEach(player -> player.teleport(tploc));
                }
            }
        }, 0L, 20L);

    }

    public static void broadcastSound(Sound sound, int volume, int pitch) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.playSound(player.getLocation(), sound, volume, pitch);
        }
    }
}
