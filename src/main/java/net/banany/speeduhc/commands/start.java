package net.banany.speeduhc.commands;

import net.banany.speeduhc.functions.system;
import net.banany.speeduhc.var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class start implements CommandExecutor {

    // When you execute the command once it starts the uhc (with the 60 seconds countdown). When the command is executed twice it shortens the timer to 10 seconds.
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("start")) {
            if (sender.hasPermission("speeduhc.start")) {
                if (Bukkit.getOnlinePlayers().size() > 1) {
                    if (var.countdownstarted) {
                        if (var.countdown <= 10) {
                            var.countdown = 50;
                            Bukkit.getServer().broadcastMessage(var.prefix + ChatColor.RED + "The countdown has been reduced to 10 seconds.");
                        } else {
                            sender.sendMessage(var.prefix + ChatColor.RED + "The countdown has already been reduced to 10 seconds.");
                        }
                    } else if (var.started) {
                        sender.sendMessage(var.prefix + ChatColor.RED + "The game already started.");
                    } else {
                        var.countdownstarted = true;
                        system.run();
                    }
                } else {
                    sender.sendMessage(var.prefix + ChatColor.RED + "You can't start the game alone.");
                }
            } else {
                sender.sendMessage(var.prefix + ChatColor.RED + "You do not have permissions to execute that command.");
            }
        }
        return false;
    }
}
