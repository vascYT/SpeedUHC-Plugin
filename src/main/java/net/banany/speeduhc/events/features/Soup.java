package net.banany.speeduhc.events.features;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Soup implements Listener {

    // This adds the soup mechanic
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getPlayer().getItemInHand().getType().equals(Material.MUSHROOM_SOUP)) {
                if (player.getHealth() != 20) {
                    if (player.getHealth() > 11) {
                        player.setHealth(20);
                        player.getInventory().setItemInHand(new ItemStack(Material.BOWL));
                    } else {
                        player.setHealth(player.getHealth() + 8);
                        player.getInventory().setItemInHand(new ItemStack(Material.BOWL));
                    }
                } else {
                    e.setCancelled(true);
                }
            }
        }

    }
}

