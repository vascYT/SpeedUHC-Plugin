package net.banany.speeduhc.functions;

import net.banany.speeduhc.SpeedUHC;
import net.banany.speeduhc.var;
import net.banany.speeduhc.waitingitems.kits.giveitems;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class system {

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
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "The game starts in 60 seconds.");
                } else if (var.countdown == 15) {
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "The game starts in 60 seconds.");
                } else if (var.countdown == 30) {
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "The game starts in 60 seconds.");
                } else if (var.countdown == 40) {
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "The game starts in 60 seconds.");
                } else if (var.countdown == 50) {
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "The game starts in 60 seconds.");
                } else if (var.countdown == 54) {
                    var.freeze = true;
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        randomtp.tp(player);
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

                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                        player.resetTitle();
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6000, 3, false, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 2, false, false));
                        giveitems.run(player);
                    }

                    var.disable_preventions = true;
                    Bukkit.getServer().broadcastMessage(var.prefix + "5 minutes until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.GREEN + "Final Heal" + ChatColor.GRAY + " is in 4 Minuten");
                } else if (var.countdown == 355) {
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "5 seconds until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                } else if (var.countdown == 356) {
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "4 seconds until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                } else if (var.countdown == 357) {
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "3 seconds until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                } else if (var.countdown == 358) {
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "2 seconds until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                } else if (var.countdown == 359) {
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                    Bukkit.getServer().broadcastMessage(var.prefix + "1 seconds until " + ChatColor.RED + "PVP" + ChatColor.GRAY + " gets enabled.");
                } else if (var.countdown == 360) {
                    var.farmworld.setPVP(true);

                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED + "PVP is now enabled.");
                    Scoreboard.set("Disabled", "Enabled", 0);
                    sound.broadcast(Sound.NOTE_BASS, 1, 2);
                } else if (var.countdown == 365) {
                    border.set(500, 300);
                } else if (var.countdown == 425) {
                    border.broadcast(500, 300);
                } else if (var.countdown == 485) {
                    border.set(300, 200);
                } else if (var.countdown == 545) {
                    border.broadcast(300, 200);
                } else if (var.countdown == 605) {
                    border.set(200, 100);
                } else if (var.countdown == 665) {
                    border.broadcast(200, 100);
                } else if (var.countdown == 625) {
                    border.set(100, 50);
                } else if (var.countdown == 685) {
                    border.broadcast(100, 50);
                } else if (var.countdown == 745) {
                    border.set(50, 10);
                } else if (var.countdown == 805) {
                    border.broadcast(50, 10);
                } else if (var.countdown == 865) {
                    border.set(10, 2);
                } else if (var.countdown == 925) {
                    border.broadcast(10, 2);
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
                    Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED + "Deathsmatch has began.");
                    border.set(2, 500);
                    Location tploc = new Location(var.farmworld, 0, Bukkit.getWorlds().get(1).getHighestBlockYAt(0, 0) + 2, 0);
                    var.players.forEach(player -> player.teleport(tploc));
                }
            }
        }, 0L, 20L);

    }
}
