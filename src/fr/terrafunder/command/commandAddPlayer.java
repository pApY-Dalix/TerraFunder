package fr.terrafunder.command;

import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandAddPlayer implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender commandSender,  Command command, String label, String[] args)
    {
        if (label.equalsIgnoreCase("Addplayer") && MakeTeam.verificationTeam)
        {
            if (commandSender instanceof Player)
            {
                if (args[0] == null || args[1] == null || args.length >= 3)
                {
                    return false;
                }
                String _team = args[0];
                String _player = args[1];
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    if (player.getDisplayName().equals(_player))
                    {
                        for (Team teammate : MakeTeam.getTeams())
                        {
                            if (teammate.getId().equals(_team))
                            {
                                if (teammate.getUuids().contains(player.getUniqueId()))
                                {
                                    MakeTeam.rmPlayer(player);
                                    player.sendMessage("§c§l>[SERVEUR] Vous avez était retirez de la team " + teammate.getName());
                                }
                                else
                                {
                                    MakeTeam.addPlayer(player, teammate);
                                    player.sendMessage("§c§l>[SERVEUR] Vous avez était ajoutez de la team " + teammate.getName());
                                }
                                player.setGameMode(GameMode.SURVIVAL);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}