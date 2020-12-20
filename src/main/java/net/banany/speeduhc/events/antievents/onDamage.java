package net.banany.speeduhc.events.antievents;

import net.banany.speeduhc.var;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class onDamage implements Listener {

    // This just prevents players from getting damage when the game isn't started
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (!var.disable_preventions) {
            if (e.getEntity() instanceof Player) {
                e.setCancelled(true);
            }
        }
    }

}
