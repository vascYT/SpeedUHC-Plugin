package net.banany.speeduhc.waitingitems.kits.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class KitsGUI {

    // Creates and open the kits gui for the player
    public static void open(Player player) {
        Inventory KitsInv = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "§lKits");

        KitsInv.setItem(0, items.defaultitem());
        KitsInv.setItem(1, items.mineritem());
        KitsInv.setItem(2, items.soupitem());
        KitsInv.setItem(3, items.sweatitem());
        KitsInv.setItem(4, items.thoritem());

        player.openInventory(KitsInv);
    }

}
