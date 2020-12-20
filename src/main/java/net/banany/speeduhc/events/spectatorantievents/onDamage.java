package net.banany.speeduhc.events.spectatorantievents;

import net.banany.speeduhc.var;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class onDamage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (var.spectators.contains(p)) {
                e.setCancelled(true);
            }
        }
    }

}
