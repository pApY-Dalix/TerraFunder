package fr.terrafunder.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class eventAntiCraft implements Listener
{
    @EventHandler
    public void blockEmerald (CraftItemEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getRecipe().getResult();
        if (itemStack.getType() == Material.EMERALD_BLOCK)
        {
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "§l> [SERVEUR] " + player.getDisplayName() + " Les blocs d'emeraude on était désactiver");
            player.setHealth(player.getHealth() - 1);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void blazePowder (CraftItemEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getRecipe().getResult();
        if (itemStack.getType() == Material.BLAZE_POWDER)
        {
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "§l> [SERVEUR] " + player.getDisplayName() + " Les potions de force on était désactiver");
            player.setHealth(player.getHealth() - 1);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void GoldenBlock (CraftItemEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getRecipe().getResult();
        if (itemStack.getType() == Material.GOLD_BLOCK)
        {
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "§l> [SERVEUR] " + player.getDisplayName() + " Les blocs d'or on était désactiver");
            player.setHealth(player.getHealth() - 1);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void Banner (CraftItemEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getRecipe().getResult();
        if (itemStack.getType() == Material.BANNER)
        {
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "§l> [SERVEUR] " + player.getDisplayName() + " Les bannières on était désactiver");
            player.setHealth(player.getHealth() - 1);
            event.setCancelled(true);
        }
    }

}