package fr.terrafunder.event;

import fr.terrafunder.scoreboard.sbAll;
import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class eventFight implements Listener
{

    @EventHandler
    public void onDamage (EntityDamageByEntityEvent event)
    {
        Player playerDamager = null;
        Player playerVictim = null;
        String _colorVictim = "WHITE";
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (event.getEntity().getType() == player.getType() && event.getDamager().getType() == player.getType())
            {
                playerDamager = (Player) event.getDamager();
                playerVictim = (Player) event.getEntity();
                for (Team team : MakeTeam.getTeams())
                {
                    if (team.getPlayer().contains(playerVictim) && team.getPlayer().contains(playerDamager))
                    {
                        playerDamager.sendMessage(ChatColor.valueOf(team.getColor()) + "Pas de friendly fire, BAKA !");
                        event.setCancelled(true);
                        return;
                    }
                    if (sbAll.day < 3)
                    {
                        playerDamager.sendMessage("§cPvp pas encore actif ! Il faut attendre le jour 3 !");
                        event.setCancelled(true);
                        return;
                    }

                }
                for (Team team : MakeTeam.getTeams())
                {
                    if (team.getPlayer().contains(playerVictim))
                    {
                        _colorVictim = team.getColor();
                    }
                }
            }
        }
        if (playerDamager != null && playerVictim != null)
        {
            playerDamager.sendMessage(ChatColor.valueOf(_colorVictim) + playerVictim.getDisplayName() + ChatColor.GREEN + " : " + playerVictim.getHealth() + "/" + playerVictim.getHealthScale());
        }
    }

    @EventHandler
    public void onProjectile (ProjectileLaunchEvent event)
    {
        Player playerDamager = null;
        Player playerVictim = null;
        String _colorVictim = "WHITE";
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (event.getEntity().getType() == player.getType())

            {
                playerVictim = player;
            }
            if (event.getEntity().getShooter() == player)
            {
                playerDamager = player;
                for (Team team : MakeTeam.getTeams())
                {
                    if (team.getPlayer().contains(playerVictim) && team.getPlayer().contains(playerDamager))
                    {
                        playerDamager.sendMessage(ChatColor.valueOf(team.getColor()) + "Pas de friendly fire, BAKA !");
                        event.setCancelled(true);
                        return;
                    }
                    if (sbAll.day < 3 && event.getEntity()instanceof Arrow)
                    {
                        playerDamager.sendMessage("§cPvp pas encore actif ! Il faut attendre le jour 3 !");
                        event.setCancelled(true);
                        return;
                    }
                }
                for (Team team : MakeTeam.getTeams())
                {
                    if (team.getPlayer().contains(playerVictim))
                    {
                        _colorVictim = team.getColor();
                    }
                }
            }
        }
        if (playerDamager != null && playerVictim != null)
        {
            playerDamager.sendMessage(ChatColor.valueOf(_colorVictim) + playerVictim.getDisplayName() + ChatColor.GREEN + " : " + playerVictim.getHealth() + "/" + playerVictim.getHealthScale());
        }
    }
}