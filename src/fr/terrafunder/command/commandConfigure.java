package fr.terrafunder.command;

import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class commandConfigure implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        if (label.equalsIgnoreCase("Configure") && commandSender.isOp() && !commandLaunch.Launch)
        {
            if (commandSender instanceof Player)
            {
                if (args.length == 0)
                {
                    for (Player player : Bukkit.getOnlinePlayers())
                    {
                        Inventory inventory = player.getInventory();
                        inventory.clear();
                    }
                    MakeTeam.CreateTeam();
                    for (Team team : MakeTeam.getTeams())
                    {
                        for (Player player : Bukkit.getOnlinePlayers())
                        {
                            player.getInventory().addItem(team.getTeam());
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}