package net.banany.speeduhc.events.JoinLeaveDeath;

import net.banany.speeduhc.SpeedUHC;
import net.banany.speeduhc.functions.*;
import net.banany.speeduhc.var;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;

import java.io.IOException;

public class onJoin implements Listener {

    // Fires when a player joins. It teleports him, sets his kit to default, creates and sets the scoreboard, it adds the bossbar, it adds the player to the mysql database if
    // he is not already in it. Then it checks if the game is started. If so the player will be set in spectator and the join message will be nothing, if not it will set a join message,
    // it will give him the waiting items. Then it will broadcast how many players are needed to start the game.
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) throws IOException {
        system.check();

        // Remove all items from inventory
        e.getPlayer().getInventory().clear();

        // Set to survival
        e.getPlayer().setGameMode(GameMode.SURVIVAL);

        // Remove potion effects
        for (PotionEffect activePotionEffect : e.getPlayer().getActivePotionEffects()) {
            e.getPlayer().removePotionEffect(activePotionEffect.getType());
        }

        // Reset xp
        e.getPlayer().setExp(0);

        // Set Health
        e.getPlayer().setHealth(20);

        // Set Food
        e.getPlayer().setFoodLevel(20);

        // Check for update
        if (e.getPlayer().hasPermission("speeduhc.admin") && !SpeedUHC.isuptodate()) {
            e.getPlayer().sendMessage(var.prefix + ChatColor.RED + "The plugin is out of date. Please update to a newer version here: https://github.com/vascYT/SpeedUHC-Plugin/releases/");
        }

        e.getPlayer().teleport(var.lobbyspawn);

        var.kits.put(e.getPlayer(), "Default");

        Scoreboard.create(e.getPlayer());

        if (var.started) {
            spectator.set(e.getPlayer());
            e.setJoinMessage("");
        } else {
            var.players.add(e.getPlayer());
            waitingitems.give(e.getPlayer());
            if (Bukkit.getOnlinePlayers().size() < 5) {
                sound.broadcast(Sound.NOTE_BASS, 1, 2);
                e.setJoinMessage(var.prefix + e.getPlayer().getDisplayName() + ChatColor.GRAY + " joined " + ChatColor.RED + "(" + Bukkit.getOnlinePlayers().size() + "/5)");
            } else {
                e.setJoinMessage(var.prefix + e.getPlayer().getDisplayName() + ChatColor.GRAY + " joined.");
            }
        }
    }
}
