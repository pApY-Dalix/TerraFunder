package fr.terrafunder.command;

import fr.terrafunder.other.theBorder;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commandBorder implements CommandExecutor
{
    private theBorder border = new theBorder();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        if (label.equalsIgnoreCase("Border"))
        {
            if (args.length == 0)
            {
                return false;
            }
            String argSize = args[0];
            String argWorld = args[1];
            int size = Integer.parseInt(argSize);
            World world = Bukkit.getWorld(argWorld);
            border.borderCreate(size, world);
            return true;
        }
        return false;
    }
}
