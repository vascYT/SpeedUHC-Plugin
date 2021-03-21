package net.banany.speeduhc.events;

import net.banany.speeduhc.functions.Win;
import net.banany.speeduhc.functions.Spectator;
import net.banany.speeduhc.var;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onDeath implements Listener {

    // Triggers when a player dies. At first he gets set as a custom spectator (with the spectator class). Then when the there is a killer (e.getEntity().getKiller() != null) then the killer gets one kills + his current kills in the database. The player who died
    // get one death + his current deaths. Then there will be a lightning strike effect (effect is important
    // otherwise it would be a real lighting strike so it would hurt players. After that it just simply sets the death message (it replaces the default message)
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        var.players.remove(e.getEntity());
        Win.check();
        e.setDeathMessage(var.prefix + e.getEntity().getDisplayName() + ChatColor.GRAY + " (" + var.kits.get(e.getEntity()) + ") died.");
        e.getEntity().setHealth(20);
        e.getEntity().sendMessage(var.prefix + ChatColor.RED + "You died.");
        Spectator.set(e.getEntity());
    }
}
