package net.banany.speeduhc.waitingitems.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class thorkit {

    // Gives the player the thor kit
    public static void give(Player player) {

        Inventory inv = player.getInventory();

        ItemStack pickaxe = new ItemStack(Material.DIAMOND_AXE);

        ItemMeta pickaxe_meta = pickaxe.getItemMeta();

        pickaxe_meta.setDisplayName(ChatColor.AQUA + "Thor hammer");

        pickaxe.setItemMeta(pickaxe_meta);

        inv.clear();

        inv.setItem(0, pickaxe);
    }

}
