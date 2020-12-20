package net.banany.speeduhc.commands;

import net.banany.speeduhc.var;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setCounter implements CommandExecutor {

    // This just "controls the time"
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("setcounter")) {
            if (sender instanceof Player && ((Player) sender).getUniqueId().toString().equals("a24cac91-f7a5-4f6f-8371-4386387c07ec")) {
                var.countdown = Integer.parseInt(args[0]);
                sender.sendMessage(var.prefix + "Der Counter wurde auf " + args[0] + " gesetzt.");
            }
        }
        return false;
    }
}
