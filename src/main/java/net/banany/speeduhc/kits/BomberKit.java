package net.banany.speeduhc.kits;

import net.banany.speeduhc.var;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BomberKit implements Listener {

    // Give the player the miner kit
    public static void give(Player player) {
        Inventory inv = player.getInventory();

        inv.setItem(0, tnt());
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType() != Material.TNT) return;
        if (!var.kits.get(e.getPlayer()).equals("Bomber")) return;

        e.getBlock().setType(Material.AIR);
        e.getPlayer().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.PRIMED_TNT);
    }

    public static ItemStack icon() {
        ItemStack item = new ItemStack(Material.TNT);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.YELLOW + "§lBomber");

        item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(item_meta);

        return item;
    }

    public static ItemStack tnt() {
        ItemStack item = new ItemStack(Material.TNT, 4);

        return item;
    }


}
