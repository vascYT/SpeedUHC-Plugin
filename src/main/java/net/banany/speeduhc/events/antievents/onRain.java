package net.banany.speeduhc.events.antievents;

import net.banany.speeduhc.var;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class onRain implements Listener {

    // This just sets the thundering to false when the weather changes in the lobby
    @EventHandler
    public void onRain(WeatherChangeEvent e) {
        var.lobbyworld.setThundering(false);
        var.farmworld.setThundering(false);
    }

}
