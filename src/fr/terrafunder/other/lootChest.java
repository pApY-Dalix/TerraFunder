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
    public static int chest()
    {
        Random rand = new Random();
        World world = Bukkit.getWorld("world");
        int _coord = (int) world.getWorldBorder().getSize() / 2;
        int x = rand.nextInt(_coord);
        int z = rand.nextInt(_coord);
        int pos_ou_neg = rand.nextInt(4);
        if (pos_ou_neg == 0) {
            x = x * -1;
            z = z * -1;
        }
        if (pos_ou_neg == 1) {
            x = x * 1;
            z = z * 1;
        }
        if (pos_ou_neg == 2) {
            x = x * -1;
            z = z * 1;
        }
        if (pos_ou_neg == 3) {
            x = x * 1;
            z = z * -1;
        }

        int y = Bukkit.getWorld("world").getHighestBlockYAt(x, z);

        Location location = new Location(world, x, y, z);
        location.getBlock().setType(Material.CHEST);
        Chest chest = (Chest) location.getBlock().getState();
        Inventory inventory = chest.getInventory();

        String[] item = {"ENDER_PEARL","EXP_BOTTLE","GOLDEN_APPLE","DIAMOND","SADDLE","BOOKSHELF","FERMENTED_SPIDER_EYE","SPECKLED_MELON","FLINT_AND_STEEL","FLINT","SHEARS","TNT"};
        String[] armor = {"DIAMOND_BOOTS","DIAMOND_LEGGINGS","RABBIT_FOOT","BLAZE_ROD","NETHER_WARTS","GHAST_TEAR","MAGMA_CREAM"};
        String[] arms = {"DIAMOND_CHESTPLATE","DIAMOND_SWORD","BOW","DIAMOND_PICKAXE","DIAMOND_HELMET","GOLDEN_CARROT","GLOWSTONE_DUST","STRING","FEATHER",};
        int i = 0;
        int j = rand.nextInt(20);
        int itemorarmororarms = rand.nextInt(3);

        while (i <= j)
        {

            if (itemorarmororarms == 0)
            {
                int nb_stack = rand.nextInt(2);
                nb_stack++;
                inventory.addItem(new ItemStack(Material.valueOf(item[rand.nextInt(item.length)]), nb_stack));
                i++;

            }
            else if(itemorarmororarms == 1)
            {
                inventory.addItem(new ItemStack(Material.valueOf(armor[rand.nextInt(armor.length)]), 1));
                int nb_stack = rand.nextInt(2);
                nb_stack++;
                inventory.addItem(new ItemStack(Material.valueOf(item[rand.nextInt(item.length)]), nb_stack));
                i++;

            }
            else if(itemorarmororarms == 2)
            {
                inventory.addItem(new ItemStack(Material.valueOf(arms[rand.nextInt(arms.length)]), 1));
                int nb_stack = rand.nextInt(2);
                nb_stack++;
                inventory.addItem(new ItemStack(Material.valueOf(item[rand.nextInt(item.length)]), nb_stack));
                i++;

            }


        }
        if (j >= 13)
        {
            Bukkit.broadcastMessage("§eUn §c§lGROS §ecoffre est apparu en §fx §6> " + x + ", §fy §6> " + y + ", §fz §6> " + z);
            Bukkit.broadcastMessage("  ");
        }
        else if (j > 9)
        {
            Bukkit.broadcastMessage("§eUn coffre §a§lMOYEN §eest apparu en §fx §6> " + x + ", §fy §6> " + y + ", §fz §6> " + z);
            Bukkit.broadcastMessage("  ");
        }
        else
        {
            Bukkit.broadcastMessage("§eUn coffre est apparu en §fx §6> " + x + ", §fy §6> " + y + ", §fz §6> " + z);
            Bukkit.broadcastMessage("  ");
        }
        return _coord;
    }
}