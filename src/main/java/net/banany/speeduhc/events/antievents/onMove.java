package net.banany.speeduhc.events.antievents;

import net.banany.speeduhc.var;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class onMove implements Listener {

    // This is an inactive event. What it does is it cancels every movement which is done on the x and y axis.
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (var.freeze) {
            Player player = e.getPlayer();
            Location from = e.getFrom();
            double xf = e.getFrom().getX();
            double zf = e.getFrom().getZ();
            double xt = e.getTo().getX();
            double zt = e.getTo().getZ();
            if (!(xf == xt && zf == zt)) {
                player.teleport(from);
            }
        }
    }

}
