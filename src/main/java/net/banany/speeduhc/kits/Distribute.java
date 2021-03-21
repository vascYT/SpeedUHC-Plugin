package net.banany.speeduhc.kits;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Distribute {

    public static void toAllPlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.getInventory().clear(); // Clear the waiting items

            switch (var.kits.get(player)) {
                case "Default":
                    DefaultKit.give(player);
                    break;
                case "Miner":
                    MinerKit.give(player);
                    break;
                case "Soup":
                    SoupKit.give(player);
                    break;
                case "Sweat":
                    SweatKit.give(player);
                    break;
                case "Thor":
                    ThorKit.give(player);
                    break;
                case "Bomber":
                    BomberKit.give(player);
                    break;
            }
        }
    }

}
