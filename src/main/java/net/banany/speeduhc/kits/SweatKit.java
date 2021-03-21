package net.banany.speeduhc.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SweatKit {

    // Gives the player the sweat kit
    public static void give(Player player) {
        Inventory inv = player.getInventory();

        inv.setItem(0, sword());
        inv.setItem(1, beef());
    }

    // The Sweat kit item for the kits gui
    public static ItemStack icon() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.YELLOW + "§lSweat");
        item_meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        item_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(item_meta);

        return item;
    }

    public static ItemStack sword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(ChatColor.AQUA + "Sweat sword");
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack beef() {
        ItemStack item = new ItemStack(Material.COOKED_BEEF, 32);

        return item;
    }

}
