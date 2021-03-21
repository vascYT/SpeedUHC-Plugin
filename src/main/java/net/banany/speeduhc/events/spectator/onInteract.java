package net.banany.speeduhc.events.spectator;

import net.banany.speeduhc.var;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class onInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (var.spectators.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
