package net.banany.speeduhc;

import net.banany.speeduhc.commands.*;
import net.banany.speeduhc.events.antievents.*;
import net.banany.speeduhc.events.features.*;
import net.banany.speeduhc.events.onDeath;
import net.banany.speeduhc.events.onJoin;
import net.banany.speeduhc.events.onLeave;
import net.banany.speeduhc.items.KitsChest;
import net.banany.speeduhc.kits.BomberKit;
import net.banany.speeduhc.kits.MinerKit;
import net.banany.speeduhc.kits.SoupKit;
import net.banany.speeduhc.kits.ThorKit;
import org.apache.commons.io.FileUtils;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public final class SpeedUHC extends JavaPlugin{

    public static SpeedUHC instance;

    @Override
    public void onEnable() {

        registerEvents();
        registerCommands();

        saveDefaultConfig();

        instance = this; // Get instance for the static methods

        // bStats
        Metrics metrics = new Metrics(this, 10661);

        // Getting Lobby spawn and world
        var.lobbyworld = Bukkit.getWorld(this.getConfig().getString("lobby.world"));
        var.lobbyspawn = new Location(var.lobbyworld, SpeedUHC.instance.getConfig().getDouble("lobby.x"), SpeedUHC.instance.getConfig().getDouble("lobby.y"), SpeedUHC.instance.getConfig().getDouble("lobby.z"), SpeedUHC.instance.getConfig().getInt("lobby.yaw"), SpeedUHC.instance.getConfig().getInt("lobby.pitch"));

        // Delete old farm world
        try {
            if (Files.exists(Paths.get("farm-world/"))) {
                Bukkit.unloadWorld("farm-world", false);
                FileUtils.deleteDirectory(new File("farm-world/"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create new farm-world
        var.farmworld = Bukkit.createWorld(new WorldCreator("farm-world"));

        // Check maps
        if (var.lobbyworld == null || var.farmworld == null) {
            System.out.println(ConsoleColor.ANSI_RED + "[SpeedUHC] ERROR: Couldn't find one of your given world names. Please update the config." + ConsoleColor.ANSI_RESET);
            this.setEnabled(false);
        } else {
            var.farmworld.setPVP(false);
            var.farmworld.getWorldBorder().setCenter(0, 0);
            var.farmworld.getWorldBorder().setSize(500);
            System.out.println(ConsoleColor.ANSI_GREEN + "[SpeedUHC] Successfully found all the given worlds." + ConsoleColor.ANSI_RESET);
        }

    }

    @Override
    public void onDisable() {
        System.out.println(ConsoleColor.ANSI_RED + "[SpeedUHC] Thanks for using my SpeedUHC plugin. The plugin has been disabled." + ConsoleColor.ANSI_RESET);
    }


    void registerEvents() {
        getServer().getPluginManager().registerEvents(new onJoin(), this);
        getServer().getPluginManager().registerEvents(new onDeath(), this);
        getServer().getPluginManager().registerEvents(new onLeave(), this);
        getServer().getPluginManager().registerEvents(new onDrop(), this);
        getServer().getPluginManager().registerEvents(new onInventoryClick(), this);
        getServer().getPluginManager().registerEvents(new KitsChest(), this);
        getServer().getPluginManager().registerEvents(new BetterEnchant(), this);
        getServer().getPluginManager().registerEvents(new onRain(), this);
        getServer().getPluginManager().registerEvents(new onInteract(), this);
        getServer().getPluginManager().registerEvents(new onDamage(), this);
        getServer().getPluginManager().registerEvents(new onDamage(), this);
        getServer().getPluginManager().registerEvents(new onHunger(), this);
        getServer().getPluginManager().registerEvents(new onMove(), this);

        // Spectator Events
        getServer().getPluginManager().registerEvents(new net.banany.speeduhc.events.spectator.onItemPickup(), this);
        getServer().getPluginManager().registerEvents(new net.banany.speeduhc.events.spectator.onPVP(), this);
        getServer().getPluginManager().registerEvents(new net.banany.speeduhc.events.spectator.onChat(), this);
        getServer().getPluginManager().registerEvents(new net.banany.speeduhc.events.spectator.onInteract(), this);
        getServer().getPluginManager().registerEvents(new net.banany.speeduhc.events.spectator.onInventoryChange(), this);

        // Kits
        getServer().getPluginManager().registerEvents(new SoupKit(), this);
        getServer().getPluginManager().registerEvents(new ThorKit(), this);
        getServer().getPluginManager().registerEvents(new BomberKit(), this);
        getServer().getPluginManager().registerEvents(new MinerKit(), this);
    }

    void registerCommands() {
        getCommand("start").setExecutor(new start());
        getCommand("healall").setExecutor(new healall());
        getCommand("setcounter").setExecutor(new setCounter());
    }

    public static Boolean isuptodate() {
        try {
            Scanner scanner = new Scanner(new URL("https://banany.net/assets/speeduhc.txt").openStream(), "UTF-8");
            String urlversion = scanner.next();
            scanner.close();

            return urlversion.equals(var.version);
        } catch (Exception e) {
            return false;
        }
    }

}