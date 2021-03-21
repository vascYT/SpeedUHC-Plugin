package net.banany.speeduhc.kits;

import net.banany.speeduhc.functions.Cooldown;
import net.banany.speeduhc.var;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ThorKit implements Listener {

    // Gives the player the thor kit
    public static void give(Player player) {
        Inventory inv = player.getInventory();

        inv.setItem(0, hammer());
    }

    // This checks if a player tries to use the thor hammer
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getItem() == null || e.getItem().getType() == Material.AIR) return;
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (!var.kits.get(e.getPlayer()).equals("Thor")) return;
        if (!e.getItem().equals(hammer())) return;

        if (!var.cooldown.containsKey(e.getPlayer())) { // Check if player has cooldown
            e.getPlayer().getWorld().strikeLightning(e.getClickedBlock().getLocation());
            Cooldown.run(e.getPlayer()); // Set player on cooldown
        } else {
            e.getPlayer().sendMessage(var.prefix + ChatColor.RED + "Slow down. Your kit is not ready yet, try again in " + var.cooldown.get(e.getPlayer()) + " seconds.");
        }
    }

    // The Thor kit item for the kits gui
    public static ItemStack icon() {
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.YELLOW + "§lThor");
        item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(item_meta);

        return item;
    }

    public static ItemStack hammer() {
        ItemStack item = new ItemStack(Material.GOLD_AXE);

        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(ChatColor.AQUA + "Thor Hammer");
        itemMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        itemMeta.spigot().setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(itemMeta);

        return item;
    }
}

