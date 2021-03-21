package net.banany.speeduhc.functions;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Spectator {

    public static void set(Player p) {
        var.spectators.add(p);
        p.getInventory().clear();
        p.setGameMode(GameMode.CREATIVE);
        p.getActivePotionEffects().forEach(potionEffect -> p.removePotionEffect(potionEffect.getType()));

        p.setAllowFlight(true);
        p.setFlying(true);

        for (Player player : Bukkit.getServer().getOnlinePlayers()) player.hidePlayer(p);

        p.setVelocity(new Vector(0, 1, 0));

        p.sendMessage(var.prefix + "You are now a spectator.");
    }

    public static void remove_all() {
        var.spectators.forEach(player -> {
            player.setAllowFlight(false);
            Bukkit.getServer().getOnlinePlayers().forEach(player2 -> {
                player2.showPlayer(player);
            });
        });
    }

}
