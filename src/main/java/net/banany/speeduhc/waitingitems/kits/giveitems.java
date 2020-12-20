package net.banany.speeduhc.waitingitems.kits;

import net.banany.speeduhc.var;
import org.bukkit.entity.Player;

public class giveitems {
    
    // Gives everyone their kit
    public static void run(Player p) {

        String playerkit = var.kits.get(p);

        p.getInventory().clear(); // Clear the waiting items

        if (playerkit.equals("Default")) {
            defaultkit.give(p);
        } else if (playerkit.equals("Miner")) {
            minerkit.give(p);
        } else if (playerkit.equals("Soup")) {
            soupkit.give(p);
        } else if (playerkit.equals("Sweat")) {
            sweatkit.give(p);
        } else if (playerkit.equals("Thor")) {
            p.sendMessage(var.prefix + "Rightclick with an axe to summon a lightning bold.");
        }

    }

}
