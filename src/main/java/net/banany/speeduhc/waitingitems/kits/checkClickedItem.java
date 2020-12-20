package net.banany.speeduhc.waitingitems.kits;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class checkClickedItem implements Listener {

    // Checks the item which is clicked in the kits gui
    @EventHandler
    public void onInvInteractionClick(InventoryClickEvent e) { // Check on what item the player clicked
        if (e.getView().getTitle().equals(ChatColor.YELLOW + "§lKits")) {
            e.setCancelled(true);
            if (e.getWhoClicked() instanceof Player) { // Check if whoclicked is a player
                Player p = Bukkit.getPlayer(e.getWhoClicked().getName()); // "Convert" HumanEntitiy into player

                String displayname = e.getCurrentItem().getItemMeta().getDisplayName();

                if (displayname.equals(ChatColor.YELLOW + "§lDefault")) { // Default Kit
                    setKit.run(p, "Default");
                    p.sendMessage(var.prefix + "Default Kit selected.");
                    e.getView().close();
                } else if (displayname.equals(ChatColor.YELLOW + "§lMiner")) { // Miner Kit
                    setKit.run(p, "Miner");
                    p.sendMessage(var.prefix + "Miner Kit selected.");
                    e.getView().close();
                } else if (displayname.equals(ChatColor.YELLOW + "§lSoup")) { // Soup Kit
                    setKit.run(p, "Soup");
                    p.sendMessage(var.prefix + "Soup Kit selected.");
                    e.getView().close();
                } else if (displayname.equals(ChatColor.YELLOW + "§lSweat")) { // Sweat Kit
                    setKit.run(p, "Sweat");
                    p.sendMessage(var.prefix + "Sweat Kit selected.");
                    e.getView().close();
                } else if (displayname.equals(ChatColor.YELLOW + "§lThor")){ // Thor Kit
                    setKit.run(p, "Thor");
                    p.sendMessage(var.prefix + "Thor Kit selected.");
                    e.getView().close();
                }
            }
        }
    }

}
