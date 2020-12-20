package net.banany.speeduhc.waitingitems.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class soupkit {

    // Give the player the soup kit
    public static void give(Player player) {

        Inventory inv = player.getInventory();

        // Create items
        ItemStack bowls = new ItemStack(Material.BOWL, 64);
        ItemStack red_mushrooms = new ItemStack(Material.RED_MUSHROOM, 64);
        ItemStack brown_mushrooms = new ItemStack(Material.BROWN_MUSHROOM, 64);

        // Clear inv
        inv.clear();

        inv.setItem(17, bowls);
        inv.setItem(16, red_mushrooms);
        inv.setItem(15, brown_mushrooms);
    }

}
