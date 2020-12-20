package net.banany.speeduhc.events.kits_use;

import net.banany.speeduhc.functions.cooldown;
import net.banany.speeduhc.var;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class onThorHammer implements Listener {

    // This checks if a player tries to use the thor hammer
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
            if (var.started) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (var.kits.get(e.getPlayer()).equals("Thor")) {
                        if (!var.cooldown.containsKey(e.getPlayer())) { // Check if player has cooldown
                            e.getPlayer().getWorld().strikeLightning(e.getClickedBlock().getLocation());
                            cooldown.run(e.getPlayer()); // Set player on cooldown
                        } else {
                            e.getPlayer().sendMessage(var.prefix + ChatColor.RED + "Slow down. Please wait " + var.cooldown.get(e.getPlayer()) + " seconds.");
                        }
                    }
                }
            }
    }

}
