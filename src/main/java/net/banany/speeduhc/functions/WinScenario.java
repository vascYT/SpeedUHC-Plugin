package net.banany.speeduhc.functions;

import net.banany.speeduhc.SpeedUHC;
import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class WinScenario {

    public static void run(Player p) {
        if (p.hasPermission("speeduhc.tnt")) {
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(SpeedUHC.instance, () -> {
                Location tntloc = new Location(p.getWorld(), -152, 3, 25);
                TNTPrimed tnt = (TNTPrimed) p.getWorld().spawnEntity(tntloc, EntityType.PRIMED_TNT);
                tnt.setFuseTicks(20);
            }, 0L, 20L);
        } else if (p.hasPermission("speeduhc.firework")) {
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(SpeedUHC.instance, () -> {
                Firework firework = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                firework.detonate();
            }, 0L, 20L);
        }
    }

}
