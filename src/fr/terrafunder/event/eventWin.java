package fr.terrafunder.event;

import fr.terrafunder.command.commandLaunch;
import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class eventWin implements Listener
{
    @EventHandler
    public void winEmeraldBlock(BlockPlaceEvent event)
    {
        Player player = event.getPlayer();
        Block win = event.getBlockPlaced();
        Location locationWin = event.getBlockPlaced().getLocation();
        Location locationSupp = new Location(locationWin.getWorld(), locationWin.getX(), locationWin.getY()-1, locationWin.getZ());
        Block supp = locationSupp.getBlock();
        if (win.getType() == Material.EMERALD_BLOCK && supp.getType() == Material.BEDROCK)
        {
            for (Team team : MakeTeam.getTeams())
            {
                if (team.getUuids().contains(player.getUniqueId()) && !team.getColor().equals("GOLD"))
                {
                    Bukkit.broadcastMessage("§c§l> [SERVEUR] VICTOIRE DE LA TEAM : " + ChatColor.valueOf(team.getColor()) + team.getName());
                    commandLaunch.stop();
                }
            }
        }
    }
}
