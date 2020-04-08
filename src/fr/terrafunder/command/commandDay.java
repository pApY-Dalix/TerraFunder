package fr.terrafunder.command;

import fr.terrafunder.scoreboard.sbAll;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandDay implements CommandExecutor{

	@Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
		if (label.equalsIgnoreCase("Day") && commandSender.isOp())
		{
			if (commandSender instanceof Player)
			{
				if (label.equalsIgnoreCase("Day"))
				{
					commandSender.sendMessage("§eJour suivant");
					sbAll.day += 1;
					return  true;
				}
			}
		}
		return false;
    }
}