package net.banany.speeduhc.events.antievents;

import net.banany.speeduhc.var;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class onHunger implements Listener {

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        if (!var.started) {
            e.setCancelled(true);
        }
    }

}
