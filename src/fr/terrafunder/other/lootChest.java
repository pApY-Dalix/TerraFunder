package fr.terrafunder.other;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class lootChest
{
    public static void chest()
    {
        Random rand = new Random();
        World world = Bukkit.getWorld("world");
        int _coord = (int) world.getWorldBorder().getSize() / 2;
        int x = rand.nextInt(_coord);
        int z = rand.nextInt(_coord);
        int y = Bukkit.getWorld("world").getHighestBlockYAt(x, z);

        Location location = new Location(world, x, y, z);
        location.getBlock().setType(Material.CHEST);
        Chest chest = (Chest) location.getBlock().getState();
        Inventory inventory = chest.getInventory();

        String[] item = {"ENDER_PEARL","EXP_BOTTLE","GOLDEN_APPLE","DIAMOND","SADDLE","BOOKSHELF","RABBIT_FOOT","BLAZE_ROD","NETHER_WARTS","GHAST_TEAR","MAGMA_CREAM","FERMENTED_SPIDER_EYE","SPECKLED_MELON","GOLDEN_CARROT","GLOWSTONE_DUST","STRING","FEATHER","FLINT_AND_STEEL","FLINT","SHEARS","TNT"};
        String[] armor = {"DIAMOND_HELMET","DIAMOND_BOOTS","DIAMOND_CHESTPLATE","DIAMOND_LEGGINGS"};
        String[] arms = {"DIAMOND_SWORD","BOW","DIAMOND_PICKAXE"};
        int i = 0;
        int j = rand.nextInt(15);

        while (i <= j)
        {
            int itemorarmororarms = rand.nextInt(2);
            if (itemorarmororarms == 0)
            {
                int nb_stack = rand.nextInt(2);
                nb_stack++;
                inventory.addItem(new ItemStack(Material.valueOf(item[rand.nextInt(item.length)]), nb_stack));
                i++;
            }
            else if(itemorarmororarms == 1)
            {
                inventory.addItem(new ItemStack(Material.valueOf(armor[rand.nextInt(item.length)]), 1));
                i++;
            }
            else if(itemorarmororarms == 2)
            {
                inventory.addItem(new ItemStack(Material.valueOf(arms[rand.nextInt(item.length)]), 1));
                i++;
            }

        }
        if (j >= 10)
        {
            Bukkit.broadcastMessage("§eUn §c§lGROS §ecoffre est apparue en §fx §6> " + x + ", §fy §6> " + y + ", §fz §6> " + z);
        }
        else if (j > 5)
        {
            Bukkit.broadcastMessage("§eUn coffre §a§lMOYEN §eest apparue en §fx §6> " + x + ", §fy §6> " + y + ", §fz §6> " + z);
        }
        else
        {
            Bukkit.broadcastMessage("§eUn coffre est apparue en §fx §6> " + x + ", §fy §6> " + y + ", §fz §6> " + z);
        }
    }
}