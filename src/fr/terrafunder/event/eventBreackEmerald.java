package fr.terrafunder.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import fr.terrafunder.scoreboard.sbAll;
import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;

public class eventBreackEmerald implements Listener
{
    @EventHandler
    public void moveEmeraldBlock(BlockBreakEvent event)
    {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if (block.getType() == Material.EMERALD_BLOCK)
        {
            for (Team team : MakeTeam.getTeams())
            {
                if (team.getPlayer().contains(player))
                {
                    if(!team.getColor().equals("GOLD") && !eventDeath.defenderDeath)
                    {
                        Bukkit.broadcastMessage(ChatColor.valueOf(team.getColor()) + team.getName() + "§c§l Vous devez tuer au moins 1 défenseur");
                        event.setCancelled(true);
                    }
                    else if(!team.getColor().equals("GOLD") && sbAll.day < 4)
                    {
                        Bukkit.broadcastMessage(ChatColor.valueOf(team.getColor()) + team.getName() + "§c§l Attendez le jours 4");
                        event.setCancelled(true);
                    }
                    else
                    {
                        Bukkit.broadcastMessage("§c§lLa team " + ChatColor.valueOf(team.getColor()) + team.getName() + "§c§l ont pris le bloc §ad'émeraude");
                    }
                }
            }
        }
    }
}
