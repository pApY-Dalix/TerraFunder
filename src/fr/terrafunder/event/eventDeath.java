package fr.terrafunder.event;

import fr.terrafunder.command.commandLaunch;
import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class eventDeath implements Listener
{
    public static boolean defenderDeath = false;

    @EventHandler
    public void onDeath (PlayerDeathEvent event)
    {
        String _colorVictim = "WHITE";
        String _colorKiller = "WHITE";
        Player playerKiller = event.getEntity().getKiller();
        Player playerDeath = event.getEntity();
        
        if(commandLaunch.Launch)
        {
            playerDeath.setGameMode(GameMode.SPECTATOR);
        }
        for (Team team : MakeTeam.getTeams())
        {
            if (team.getUuids().contains(playerDeath.getUniqueId()))
            {
                _colorVictim = team.getColor();
                team.removePlayer(playerDeath.getUniqueId());
            }
            else if (team.getUuids().contains(playerKiller.getUniqueId()))
            {
                _colorKiller = team.getColor();
            }
        }
        event.getDeathMessage();
        if (playerKiller.equals(null))
        {
            event.setDeathMessage("§c§l† " + ChatColor.valueOf(_colorVictim) + playerDeath.getDisplayName() + " est mort PVE comme une merde, sa Team l'a bannie §c§l†");
            World world = Bukkit.getWorld("world");
            world.playSound(playerDeath.getLocation(), Sound.ZOMBIE_REMEDY, 1000.0F, 1.0F);
        }
        else
        {
            event.setDeathMessage("§c§l† " + ChatColor.valueOf(_colorVictim) + playerDeath.getDisplayName() + ChatColor.RED + " §là était tuer par " + ChatColor.valueOf(_colorKiller) + playerKiller.getDisplayName() + " §c§l†");
            World world = Bukkit.getWorld("world");
            world.playSound(playerDeath.getLocation(), Sound.ZOMBIE_REMEDY, 1000.0F, 1.0F);
            if (_colorVictim.equals("GOLD") && !defenderDeath)
            {
                defenderDeath = true;
                event.setDeathMessage("§c§l† §eUn §6défenseur §eest mort. Les §f§lattaquants §epeuvent prendre le bloc §ad'émeraude §esi on et minimum jours 4 §c§l†");
            }
        }
    }
}
