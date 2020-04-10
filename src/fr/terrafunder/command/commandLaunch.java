package fr.terrafunder.command;

import fr.terrafunder.other.theBorder;
import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class commandLaunch implements CommandExecutor {
    private List<Player> players = new ArrayList<>();
    private double x[] = {92, 650, 650, 650, 0, 0, -650, -650, -650};
    private double y = 0;
    private double z[] = {72, 650, 0, -650, 650, -650, 650, 0, -650};
    private int i;
    private int j;
    public static boolean Launch = false;
    private theBorder Border = new theBorder();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        if (label.equalsIgnoreCase("Launch") && commandSender.isOp())
        {
            if (commandSender instanceof Player)
            {
                World world = ((Player) commandSender).getWorld();
                if (args[0].equalsIgnoreCase("Start"))
                {
                    if (!Launch && MakeTeam.verificationTeam)
                    {
                        start();
                    }
                    else
                    {
                        if (!MakeTeam.verificationTeam)
                        {
                            Bukkit.broadcastMessage(ChatColor.RED + "> [SERVEUR] No Team");
                        }
                        else
                        {
                            Bukkit.broadcastMessage(ChatColor.RED + "> [SERVEUR] Le §a§lTerraFunder §c as déjà Start :c");
                        }
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("Stop"))
                {
                    if (Launch)
                    {
                        stop();
                    }
                    else
                    {
                        Bukkit.broadcastMessage(ChatColor.RED + "> [SERVEUR] Le $a$lTerraFunder $cn'a pas start :c");
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static void stop()
    {
        World world = Bukkit.getWorld("world");
        Location spawn = new Location(Bukkit.getWorld("world"), 0, world.getHighestBlockYAt(0, 0), 0);
        for (Player player : Bukkit.getOnlinePlayers())
        {
            player.setGameMode(GameMode.SPECTATOR);
            player.teleport(spawn);
        }
        MakeTeam.resetTeam();
        world.setTime(0);
        Launch = false;
    }

    public void start()
    {
        i = 0;
        j = 0;
        World world = Bukkit.getWorld("world");
        Bukkit.broadcastMessage(ChatColor.RED +"> §l[SERVEUR] §cPréparation au lancement du §a§lTerrafunder ... ");
        for (Team team : MakeTeam.getTeams())
        {
            y = world.getHighestBlockYAt((int) x[i], (int) z[j]);
            Location location = new Location(world, x[i], y+3, z[j]);
            players = team.getPlayer();
            for (Player player : players)
            {
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*62, 255));
                player.teleport(location);
                player.setGameMode(GameMode.SURVIVAL);
                player.setHealth(20);
                player.setFoodLevel(20);
                world.setDifficulty(Difficulty.PEACEFUL);
                Inventory inventory = player.getInventory();
                inventory.clear();
                player.setExp(0);
                inventory.addItem(new ItemStack(Material.COOKED_BEEF, 64));
                world.setDifficulty(Difficulty.HARD);
            }
            i++;
            j++;
        }
        Bukkit.broadcastMessage("     ");
        Bukkit.broadcastMessage(ChatColor.GOLD + "> §c§lSERVEUR] §6Bonne chance a §f§lTOUS");
        Bukkit.broadcastMessage("     ");
        Bukkit.broadcastMessage("§c> §c§l[SERVEUR] §c1 minute avant les dégàts actif !");
        world.setTime(0);
        Launch = true;
    }
}