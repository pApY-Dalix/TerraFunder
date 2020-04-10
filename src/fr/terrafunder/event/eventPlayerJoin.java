package fr.terrafunder.event;

import fr.terrafunder.command.commandLaunch;
import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class eventPlayerJoin implements Listener
{
    @EventHandler
    public void PlayerJoin (PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        event.setJoinMessage("§7[§3+§7] " + player.getDisplayName());
        if(commandLaunch.Launch)
        {
            for(Team team : MakeTeam.getTeams())
            {
                for (UUID uuid : team.getUuids())
                {
                    if(player.getUniqueId().equals(uuid))
                    {
                        MakeTeam.rmPlayer(player, player.getUniqueId());
                        MakeTeam.addPlayer(player, team);
                    }
                    else
                    {
                        return;
                    }
                }
            }
        }
        else if (!player.isOp())
        {
            player.setGameMode(GameMode.ADVENTURE);
            player.setHealth(20);
            player.setFoodLevel(20);
            Inventory inventory = player.getInventory();
            inventory.clear();
        }
    }

    @EventHandler
    public void PlayerLeave (PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        event.setQuitMessage("§7[§4-§7] " + player.getDisplayName());
    }
}
