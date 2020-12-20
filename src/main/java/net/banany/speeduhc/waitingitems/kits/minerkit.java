package net.banany.speeduhc.waitingitems.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class minerkit {

    // Give the player the miner kit
    public static void give(Player player) {

        Inventory inv = player.getInventory();

        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);

        ItemStack torch = new ItemStack(Material.TORCH, 32);

        ItemStack tnt = new ItemStack(Material.TNT, 4);


        ItemMeta pickaxe_meta = pickaxe.getItemMeta();

        pickaxe_meta.setDisplayName(ChatColor.AQUA + "Miner Pickaxe");

        pickaxe_meta.addEnchant(Enchantment.DIG_SPEED, 2, false);

        pickaxe.setItemMeta(pickaxe_meta);

        inv.clear();

        inv.setItem(0, pickaxe);
        inv.setItem(1, torch);
        inv.setItem(2, tnt);

    }

}
