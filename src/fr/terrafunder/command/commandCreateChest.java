package fr.terrafunder.command;

import fr.terrafunder.other.lootChest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commandCreateChest implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        if (label.equalsIgnoreCase("Chest"))
        {
            if (args.length == 0)
            {
                lootChest.chest();
                return true;
            }
        }
        return false;
    }
}