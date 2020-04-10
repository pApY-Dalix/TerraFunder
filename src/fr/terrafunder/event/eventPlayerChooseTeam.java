package fr.terrafunder.event;

import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class eventPlayerChooseTeam implements Listener
{
    @SuppressWarnings("deprecated")
    @EventHandler
    public void inventoryInteract(InventoryClickEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getCurrentItem();
        if (itemStack != null && itemStack.getType() == Material.BANNER)
        {
            for (Team team : MakeTeam.getTeams())
            {
                if (team.getData() == itemStack.getData().getData())
                {
                    if(!team.getUuids().contains(player.getUniqueId()))
                    {
                        MakeTeam.rmPlayer(player);
                        MakeTeam.addPlayer(player, team);

                    }
                }
            }
        }
    }

    @SuppressWarnings("deprecated")
    @EventHandler
    public void woolInteract(PlayerInteractEvent event)
    {
        Player player = (Player) event.getPlayer();
        ItemStack itemStack = event.getItem();
        if (itemStack != null && itemStack.getType() == Material.BANNER)
        {
            for (Team team : MakeTeam.getTeams())
            {
                if (team.getData() == itemStack.getData().getData())
                {
                    if(!team.getUuids().contains(player.getUniqueId()))
                    {
                        MakeTeam.rmPlayer(player);
                        MakeTeam.addPlayer(player, team);

                    }
                }
            }
        }
    }
}
