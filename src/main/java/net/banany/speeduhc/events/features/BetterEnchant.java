package net.banany.speeduhc.events.features;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class BetterEnchant implements Listener {

    // This just fires when a player prepares an item craft (when he puts for example wood into the crafting bench). When the result = a wooden pickaxe/axe/shovel then it replaces
    // it with a better version of it.
    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {

        if (Objects.requireNonNull(e.getInventory().getResult()).getType() == Material.WOOD_AXE) {

            ItemStack item = new ItemStack(Material.IRON_AXE);
            ItemMeta itemmeta = item.getItemMeta();
            itemmeta.addEnchant(Enchantment.DIG_SPEED, 2, false);
            itemmeta.addEnchant(Enchantment.DURABILITY, 2, false);
            item.setItemMeta(itemmeta);

            e.getInventory().setResult(item);

        } else if (Objects.requireNonNull(e.getInventory().getResult()).getType() == Material.WOOD_PICKAXE) {

            ItemStack item = new ItemStack(Material.IRON_PICKAXE);
            ItemMeta itemmeta = item.getItemMeta();
            itemmeta.addEnchant(Enchantment.DIG_SPEED, 2, false);
            itemmeta.addEnchant(Enchantment.DURABILITY, 2, false);
            item.setItemMeta(itemmeta);

            e.getInventory().setResult(item);

        } else if (Objects.requireNonNull(e.getInventory().getResult()).getType() == Material.WOOD_SPADE) {

            ItemStack item = new ItemStack(Material.IRON_SPADE);
            ItemMeta itemmeta = item.getItemMeta();
            itemmeta.addEnchant(Enchantment.DIG_SPEED, 2, false);
            itemmeta.addEnchant(Enchantment.DURABILITY, 2, false);
            item.setItemMeta(itemmeta);

            e.getInventory().setResult(item);

        }


    }

}
