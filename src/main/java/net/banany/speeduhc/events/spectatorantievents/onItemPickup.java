package net.banany.speeduhc.events.spectatorantievents;

import net.banany.speeduhc.var;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class onItemPickup implements Listener {

    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        if (var.spectators.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }

}
