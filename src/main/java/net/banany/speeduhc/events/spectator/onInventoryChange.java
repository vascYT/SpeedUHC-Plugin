package net.banany.speeduhc.events.spectator;

import net.banany.speeduhc.var;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class onInventoryChange implements Listener {

    @EventHandler
    public void onChat(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            if (var.spectators.contains(p)) {
                e.setCancelled(true);
            }
        }
    }

}
