package fr.terrafunder.command;

import fr.terrafunder.team.MakeTeam;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class commandConfigure implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        if (label.equalsIgnoreCase("Configure") && commandSender.isOp() && !commandLaunch.Launch)
        {
            if (commandSender instanceof Player)
            {
                if (args.length == 0)
                {
                    for (Player player : Bukkit.getOnlinePlayers())
                    {
                        Inventory inventory = player.getInventory();
                        inventory.clear();
                    }
                    MakeTeam.CreateTeam();
                    for (Player player : Bukkit.getOnlinePlayers())
                    {
                        ItemStack chesteam = new ItemStack(Material.CHEST,1);
                        ItemMeta _Chest = chesteam.getItemMeta();
                        _Chest.setDisplayName("§6Sélecteur de team");
                        chesteam.setItemMeta(_Chest);
                        player.getInventory().addItem(chesteam);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}