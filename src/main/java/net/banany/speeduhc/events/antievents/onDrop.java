package net.banany.speeduhc.events.antievents;

import net.banany.speeduhc.var;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class onDrop implements Listener {

    // This prevents the player from dropping something when the game isn't started
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (!var.disable_preventions) {
            e.setCancelled(true);
        }
    }

}
