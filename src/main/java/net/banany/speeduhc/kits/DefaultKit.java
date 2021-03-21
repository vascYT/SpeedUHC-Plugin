package net.banany.speeduhc.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class DefaultKit {

    // Gives the player the default kit
    public static void give(Player player) {
        Inventory inv = player.getInventory();

        inv.setItem(0, sword());
    }

    public static ItemStack icon() {
        ItemStack item = new ItemStack(Material.STONE_SWORD);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.GRAY + "Default");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "");
        item_meta.setLore(lore);

        item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(item_meta);

        return item;
    }

    public static ItemStack sword() {
        ItemStack item = new ItemStack(Material.STONE_SWORD);

        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(ChatColor.GRAY + "Default sword");

        item.setItemMeta(itemMeta);

        return item;
    }

}
