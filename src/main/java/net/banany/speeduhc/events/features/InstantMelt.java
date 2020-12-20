package net.banany.speeduhc.events.features;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class InstantMelt implements Listener {

    // This fires when someone breaks gold ore or iron ore. When this happens it cancels the drop (the ore block) and drops the melted version of the ore at the location
    @EventHandler
    public void onIronMine(BlockBreakEvent e) {
        if (e.getBlock() != null && e.getBlock().getType().equals(Material.IRON_ORE)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
            var.farmworld.dropItem(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
        } else if (e.getBlock() != null && e.getBlock().getType().equals(Material.GOLD_ORE)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
            var.farmworld.dropItem(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
        }
    }



}
