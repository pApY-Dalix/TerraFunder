package fr.terrafunder.command;

import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commandRemovePlayer implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender commandSender,  Command command, String label, String[] args)
    {
        if (label.equalsIgnoreCase("RemovePlayer") && MakeTeam.verificationTeam)
        {
            for (Team team : MakeTeam.getTeams())
            {
                for (OfflinePlayer player : Bukkit.getOfflinePlayers())
                {
                    if (team.getUuids().contains(player.getUniqueId()))
                    {
                        team.removePlayer(player.getUniqueId());
                        Bukkit.broadcastMessage("§a>[SERVEUR] La suppressions à été effectuer");
                        return true;
                    }
                }
            }
            return true;
        }
        return false;
    }
}