package net.banany.speeduhc.events.spectator;

import net.banany.speeduhc.var;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (var.spectators.contains(e.getPlayer())) {
            e.getRecipients().removeAll(var.players);
            e.setFormat(ChatColor.RED + "✘ " + ChatColor.GRAY + e.getPlayer().getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + e.getMessage());
        }
    }

}
