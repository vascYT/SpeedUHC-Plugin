package net.banany.speeduhc.functions;

import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class sound {

    // This method just simply plays a specfic sound to every player
    public static void broadcast(Sound sound, int volume, int pitch) {
        Bukkit.getServer().getOnlinePlayers().forEach((player -> {
            player.playSound(player.getLocation(), sound, volume, pitch);
        }));

    }

}
