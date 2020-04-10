package fr.terrafunder.event;

import fr.terrafunder.command.commandLaunch;
import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class eventPlayerJoin implements Listener
{
    @EventHandler
    public void PlayerJoin (PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        World world = Bukkit.getWorld("world");
        Location location = new Location(world, 58,165,81);
        event.setJoinMessage("§7[§3+§7] " + player.getDisplayName());
        if(commandLaunch.Launch)
        {
            for(Team team : MakeTeam.getTeams())
            {
                for (UUID uuid : team.getUuids())
                {
                    if(player.getUniqueId().equals(uuid))
                    {
                        MakeTeam.rmPlayer(player);
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
            player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 999999, 255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999, 255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 255));
            player.teleport(location);
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
