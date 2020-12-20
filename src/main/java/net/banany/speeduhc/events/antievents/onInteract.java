package net.banany.speeduhc.events.antievents;

import net.banany.speeduhc.var;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class onInteract implements Listener {

    // Cancels interactions when the game isn't started
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (!var.started) {
            e.setCancelled(true);
        }
    }
}
