package net.banany.speeduhc.waitingitems.kits.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class items {

    // The Default kit item for the kits gui
    public static ItemStack defaultitem() {
        ItemStack item = new ItemStack(Material.STONE_SWORD);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.YELLOW + "§lDefault");

        item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(item_meta);

        return item;
    }

    // The Miner Kit item for the kits gui
    public static ItemStack mineritem() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.YELLOW + "§lMiner");

        item_meta.addEnchant(Enchantment.DIG_SPEED, 1, false);

        item_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(item_meta);

        return item;
    }

    // The Soup Kit item for the kits gui
    public static ItemStack soupitem() {
        ItemStack item = new ItemStack(Material.MUSHROOM_SOUP);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.YELLOW + "§lSoup");

        item.setItemMeta(item_meta);

        return item;
    }

    // The Sweat kit item for the kits gui
    public static ItemStack sweatitem() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.YELLOW + "§lSweat");
        item_meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        item_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(item_meta);

        return item;
    }

    // The Thor kit item for the kits gui
    public static ItemStack thoritem() {
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.YELLOW + "§lThor");
        item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(item_meta);

        return item;
    }

}
