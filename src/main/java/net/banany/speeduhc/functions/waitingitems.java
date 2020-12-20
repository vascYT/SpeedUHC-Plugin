package net.banany.speeduhc.functions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class waitingitems {

    // This gives the player the kits item (chest) and the back to lobby item (arrow)
    public static void give(Player player) {
        Inventory inv = player.getInventory();

        ItemStack kits_item = new ItemStack(Material.CHEST);

        ItemMeta kits_meta = kits_item.getItemMeta();

        kits_meta.setDisplayName(ChatColor.YELLOW + "§lKits");

        kits_item.setItemMeta(kits_meta);

        inv.setItem(0, kits_item);
    }

}
