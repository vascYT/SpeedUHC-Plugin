package net.banany.speeduhc.kits;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SoupKit implements Listener {

    // Give the player the soup kit
    public static void give(Player player) {
        Inventory inv = player.getInventory();

        inv.setItem(17, bowls());
        inv.setItem(16, red_mushrooms());
        inv.setItem(15, brown_mushrooms());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (!e.getPlayer().getItemInHand().getType().equals(Material.MUSHROOM_SOUP)) return;
        if (!var.kits.get(e.getPlayer()).equals("Soup")) return;

        e.setCancelled(true);

        Player player = e.getPlayer();
        if (player.getHealth() != 20) {
            if (player.getHealth() > 11) {
                player.setHealth(20);
            } else {
                player.setHealth(player.getHealth() + 8);
            }
            player.getInventory().setItemInHand(new ItemStack(Material.BOWL));
        }
    }

    // The Soup Kit item for the kits gui
    public static ItemStack icon() {
        ItemStack item = new ItemStack(Material.MUSHROOM_SOUP);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.YELLOW + "§lSoup");

        item.setItemMeta(item_meta);

        return item;
    }

    public static ItemStack bowls() {
        ItemStack item = new ItemStack(Material.BOWL, 64);

        return item;
    }

    public static ItemStack red_mushrooms() {
        ItemStack item = new ItemStack(Material.RED_MUSHROOM, 64);

        return item;
    }

    public static ItemStack brown_mushrooms() {
        ItemStack item = new ItemStack(Material.BROWN_MUSHROOM, 64);

        return item;
    }
}
