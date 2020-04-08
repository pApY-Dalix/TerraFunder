package fr.terrafunder.event;

import fr.terrafunder.command.commandLaunch;
import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

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
                if(team.getPlayer().contains(player))
                {
                    return;
                }
                else
                {
                    player.setHealth(20);
                    player.setFoodLevel(20);
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
        //for (Team team : MakeTeam.getTeams())
       // {
         //   if (team.getPlayer().contains(player))
          //  {
           //     team.rmPlayer(player);
            //    event.setQuitMessage(ChatColor.valueOf(team.getColor()) + player.getDisplayName() + " à quitter votre team");
           // }
        //}
        event.setQuitMessage("§7[§4-§7] " + player.getDisplayName());
    }
}
