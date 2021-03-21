package net.banany.speeduhc.items;

import net.banany.speeduhc.functions.Scoreboard;
import net.banany.speeduhc.kits.*;
import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsChest implements Listener {

    public static ItemStack item() {
        ItemStack item = new ItemStack(Material.CHEST);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "§lKits");

        item.setItemMeta(meta);

        return item;
    }

    // Creates and open the kits gui for the player
    void openInv(Player player) {
        Inventory KitsInv = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "§lKits");

        KitsInv.setItem(0, DefaultKit.icon());
        KitsInv.setItem(1, MinerKit.icon());
        KitsInv.setItem(2, SoupKit.icon());
        KitsInv.setItem(3, ThorKit.icon());
        KitsInv.setItem(4, BomberKit.icon());

        player.openInventory(KitsInv);
    }

    @EventHandler
    public void onItemInteract(PlayerInteractEvent e) { // Open GUI
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && !e.getAction().equals(Action.RIGHT_CLICK_AIR)) return;
        if (e.getItem() == null || e.getItem().getItemMeta().getDisplayName() == null || e.getItem().getType() == Material.AIR) return;

        if (e.getItem().getItemMeta().getDisplayName().equals(item().getItemMeta().getDisplayName())) {
            e.setCancelled(true);
            openInv(e.getPlayer());
        }
    }

    // Checks the item which is clicked in the kits gui
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) { // Check on what item the player clicked
        if (!e.getView().getTitle().equals(ChatColor.YELLOW + "§lKits")) return;
        if (!(e.getWhoClicked() instanceof Player)) return;
        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return; // Check if user clicked in not an item

        Player p = Bukkit.getPlayer(e.getWhoClicked().getName());

        e.setCancelled(true);
        String kitsname = e.getCurrentItem().getItemMeta().getDisplayName().substring(4); // Substring removes color codes

        var.kits.replace(p, kitsname); // Save kit.

        p.sendMessage(var.prefix + kitsname + " Kit selected.");
        e.getView().close();

        Scoreboard.refreshForPlayer(p); // Update scoreboard
    }
}
