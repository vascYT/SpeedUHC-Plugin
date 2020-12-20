package net.banany.speeduhc.waitingitems.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class defaultkit {

    // Gives the player the default kit
    public static void give(Player player) {

        ItemStack sword = new ItemStack(Material.STONE_SWORD);

        Inventory inv = player.getInventory();

        ItemMeta sword_meta = sword.getItemMeta();

        sword_meta.setDisplayName(ChatColor.GRAY + "Default sword.");

        sword.setItemMeta(sword_meta);

        inv.clear();

        inv.setItem(0, sword);
    }

}
