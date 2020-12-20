package net.banany.speeduhc.functions;

import net.banany.speeduhc.var;
import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class randomtp {

    // This teleports a specfic player to a random location
    public static void tp(Player player) {

        int x = RandomUtils.nextInt(250);
        int z = RandomUtils.nextInt(250);
        int y = var.farmworld.getHighestBlockYAt(x, z) + 1;

        player.teleport(new Location(var.farmworld, x, y, z));
    }
}
