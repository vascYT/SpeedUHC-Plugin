package net.banany.speeduhc.waitingitems.kits;

import net.banany.speeduhc.waitingitems.kits.gui.KitsGUI;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class onKitsItemUse implements Listener {

    // Opens the Kits GUI if the player uses the kits item (chest)
    @EventHandler
    public void onItemInteract(PlayerInteractEvent e) { // Open GUI
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            try {
                if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "§lKits")) {
                    KitsGUI.open(e.getPlayer());
                }
            } catch (NullPointerException ignored){}
        }
    }
}
