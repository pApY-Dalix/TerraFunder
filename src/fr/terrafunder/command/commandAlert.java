package fr.terrafunder.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandAlert implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        if (label.equalsIgnoreCase("Alert"))
        {
            if (commandSender instanceof Player)
            {
                if (args.length == 0)
                {
                    return false;
                }
                String arg = "§c§l> [SERVEUR]";
                for (String part : args)
                {
                    arg += " " + part;
                }
                if (commandSender.isOp())
                {
                    Bukkit.broadcastMessage(arg);
                }
                else
                {
                    commandSender.sendMessage("§c§l> [SERVEUR] Vous n'avez pas la permission");
                }
                return true;
            }
        }
        return false;
    }
}
