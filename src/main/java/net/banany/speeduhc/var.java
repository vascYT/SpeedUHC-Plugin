package net.banany.speeduhc;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

// This class just defines all static variables. You can use them with var.<variablename> in another class. These should get defined when the plugin initializes.
public class var {

    public static boolean started;

    public static boolean disable_preventions = false;

    public static boolean win;

    public static String prefix = ChatColor.translateAlternateColorCodes('&', SpeedUHC.instance.getConfig().getString("prefix"));

    public static String scoreboard_title = ChatColor.translateAlternateColorCodes('&', SpeedUHC.instance.getConfig().getString("scoreboard-title")) ;

    public static World lobbyworld;

    public static Location lobbyspawn;

    public static World farmworld;

    public static HashMap<Player, String> kits = new HashMap<>();

    public static HashMap<Player, Integer> cooldown = new HashMap<>();

    public static ArrayList<Player> players = new ArrayList<>();

    public static ArrayList<Player> spectators = new ArrayList<>();

    public static Boolean countdownstarted = false;

    public static int countdown = 0;

    public static Boolean freeze = false;

    public static String version = "1.3";

}
