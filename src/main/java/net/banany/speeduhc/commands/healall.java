package net.banany.speeduhc.commands;

import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healall implements CommandExecutor {

    // This is the healall command, which just simply heals all players (health and food) and it broadcasts a title to every player and a message to the executor
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("healall")) {
            if (sender.hasPermission("speeduhc.healall")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                }
                Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.GREEN + sender.getName() + " healed everyone.");
                sender.sendMessage(var.prefix + "All players healed.");
            } else {
                sender.sendMessage(var.prefix + ChatColor.RED + "You do not have permissions to execute that command.");
            }
        }
        return false;
    }
}
