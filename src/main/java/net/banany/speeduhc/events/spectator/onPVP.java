package net.banany.speeduhc.events.spectator;

import net.banany.speeduhc.var;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class onPVP implements Listener {

    @EventHandler
    public void onPVP(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            if (var.spectators.contains(p)) {
                e.setCancelled(true);
            }
        }
    }

}
