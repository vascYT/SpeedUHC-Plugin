package net.banany.speeduhc.events;

import net.banany.speeduhc.functions.Win;
import net.banany.speeduhc.functions.Game;
import net.banany.speeduhc.var;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onLeave implements Listener {

    // Triggers when a player leaves and when a player gets kicked. At first it removes the player from the players array. Then it will set a quit message.
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        var.players.remove(e.getPlayer());

        Game.check();
        Win.check();

        e.setQuitMessage(var.prefix + e.getPlayer().getDisplayName() + ChatColor.GRAY + " left.");
    }
}
