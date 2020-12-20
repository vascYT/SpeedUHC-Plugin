package net.banany.speeduhc.functions;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class spectator {

    public static void set(Player p) {

        var.spectators.add(p);

        p.getInventory().clear();

        p.setGameMode(GameMode.ADVENTURE);

        p.setAllowFlight(true);
        p.setFlying(true);

        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.hidePlayer(p);
        }

    }

    public static void removeall() {
        var.spectators.forEach(player -> {
            player.setAllowFlight(false);
            Bukkit.getServer().getOnlinePlayers().forEach(player2 -> {
                player2.showPlayer(player);
            });
        });
    }

}
