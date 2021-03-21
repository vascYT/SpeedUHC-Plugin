package net.banany.speeduhc.kits;

import net.banany.speeduhc.var;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MinerKit implements Listener {

    // Give the player the miner kit
    public static void give(Player player) {
        Inventory inv = player.getInventory();

        inv.setItem(0, pickaxe());
        inv.setItem(1, torches());
    }

    // This fires when someone breaks gold ore or iron ore. When this happens it cancels the drop (the ore block) and drops the melted version of the ore at the location
    @EventHandler
    public void onIronMine(BlockBreakEvent e) {
        if (!var.kits.get(e.getPlayer()).equals("Miner")) return;

        if (e.getBlock() != null && e.getBlock().getType().equals(Material.IRON_ORE)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
            var.farmworld.dropItem(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
        } else if (e.getBlock() != null && e.getBlock().getType().equals(Material.GOLD_ORE)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
            var.farmworld.dropItem(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
        }
    }

    // The Miner Kit item for the kits gui
    public static ItemStack icon() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);

        ItemMeta item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.YELLOW + "§lMiner");

        item_meta.addEnchant(Enchantment.DIG_SPEED, 1, false);

        item_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(item_meta);

        return item;
    }

    public static ItemStack pickaxe() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);

        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(ChatColor.AQUA + "Miner Pickaxe");
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 2, false);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack torches() {
        ItemStack item = new ItemStack(Material.TORCH, 32);

        return item;
    }

}
