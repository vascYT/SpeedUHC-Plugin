package net.banany.speeduhc.waitingitems.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class sweatkit {

    // Gives the player the sweat kit
    public static void give(Player player) {

        Inventory inv = player.getInventory();

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);

        ItemStack food = new ItemStack(Material.COOKED_BEEF, 32);


        ItemMeta sword_meta = sword.getItemMeta();

        sword_meta.setDisplayName(ChatColor.AQUA + "Sweat sword");

        sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);


        sword.setItemMeta(sword_meta);
        inv.clear();

        inv.setItem(0, sword);
        inv.setItem(1, food);
    }

}
