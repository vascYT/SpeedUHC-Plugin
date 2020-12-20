package net.banany.speeduhc;

import net.banany.speeduhc.commands.*;
import net.banany.speeduhc.events.JoinLeaveDeath.*;
import net.banany.speeduhc.events.antievents.*;
import net.banany.speeduhc.events.features.*;
import net.banany.speeduhc.events.kits_use.onThorHammer;
import net.banany.speeduhc.events.spectatorantievents.onChat;
import net.banany.speeduhc.events.spectatorantievents.onItemPickup;
import net.banany.speeduhc.events.spectatorantievents.onPVP;
import net.banany.speeduhc.functions.*;
import net.banany.speeduhc.waitingitems.kits.*;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public final class SpeedUHC extends JavaPlugin{

    public static SpeedUHC instance;

    @Override
    public void onEnable() {
        // This registers all events
        getServer().getPluginManager().registerEvents(new onJoin(), this);
        getServer().getPluginManager().registerEvents(new net.banany.speeduhc.events.antievents.onInteract(), this);
        getServer().getPluginManager().registerEvents(new net.banany.speeduhc.events.antievents.onDamage(), this);
        getServer().getPluginManager().registerEvents(new onDeath(), this);
        getServer().getPluginManager().registerEvents(new onLeave(), this);
        getServer().getPluginManager().registerEvents(new onDrop(), this);
        getServer().getPluginManager().registerEvents(new net.banany.speeduhc.events.antievents.onInventoryClick(), this);
        getServer().getPluginManager().registerEvents(new InstantMelt(), this);
        getServer().getPluginManager().registerEvents(new onThorHammer(), this);
        getServer().getPluginManager().registerEvents(new onKitsItemUse(), this);
        getServer().getPluginManager().registerEvents(new checkClickedItem(), this);
        getServer().getPluginManager().registerEvents(new betterEnchant(), this);
        getServer().getPluginManager().registerEvents(new onRain(), this);
        getServer().getPluginManager().registerEvents(new instantTNT(), this);
        getServer().getPluginManager().registerEvents(new net.banany.speeduhc.events.spectatorantievents.onInteract(), this);
        getServer().getPluginManager().registerEvents(new onItemPickup(), this);
        getServer().getPluginManager().registerEvents(new onPVP(), this);
        getServer().getPluginManager().registerEvents(new onChat(), this);
        getServer().getPluginManager().registerEvents(new net.banany.speeduhc.events.spectatorantievents.onDamage(), this);
        getServer().getPluginManager().registerEvents(new onMove(), this);
        getServer().getPluginManager().registerEvents(new onHunger(), this);
        getServer().getPluginManager().registerEvents(new Soup(), this);

        // This registers/sets the Executor for all commands
        getCommand("start").setExecutor(new start());
        getCommand("healall").setExecutor(new healall());
        getCommand("setcounter").setExecutor(new setCounter());

        // This runs the checkwin.run() and the system.check() method every second
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            system.check();
            checkWin.run();
        }, 0L, 20L);

        saveDefaultConfig();

        instance = this; // Get instance for the static methods

        // Check maps
        if (var.lobbyworld == null || var.farmworld == null) {
            System.out.println(ConsoleColor.ANSI_RED + "[SpeedUHC] ERROR: Couldn't find one of your given world names. Please update the config." + ConsoleColor.ANSI_RESET);
            this.setEnabled(false);
        } else {
            System.out.println(ConsoleColor.ANSI_GREEN + "[SpeedUHC] Successfully found all the given worlds." + ConsoleColor.ANSI_RESET);
        }

        var.farmworld.setPVP(false);
        var.farmworld.getWorldBorder().setCenter(0, 0);
        var.farmworld.getWorldBorder().setSize(500);

        System.out.println(ConsoleColor.ANSI_GREEN + "[SpeedUHC] The plugin has been enabled." + ConsoleColor.ANSI_RESET);

    }

    @Override
    public void onDisable() {
        System.out.println(ConsoleColor.ANSI_RED + "[SpeedUHC] Thanks for using my Speed-UHC plugin. The plugin has been disabled." + ConsoleColor.ANSI_RESET);
    }


    public static Boolean isuptodate() throws IOException {
        Scanner scanner = new Scanner(new URL("https://vasc.dev/version/speeduhc.txt").openStream(), "UTF-8");

        String urlversion = scanner.next();

        scanner.close();

        return urlversion.equals(var.version);
    }

}