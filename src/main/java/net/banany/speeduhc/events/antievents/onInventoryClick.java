package net.banany.speeduhc.events.antievents;

import net.banany.speeduhc.var;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class onInventoryClick implements Listener {

    // This cancels all inventory clicks when the game isn't started
    @EventHandler
    public void onInventoryAction(InventoryClickEvent e) {
        if (!var.disable_preventions) {
            e.setCancelled(true);
        }
    }

}
