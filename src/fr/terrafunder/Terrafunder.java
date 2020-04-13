package fr.terrafunder;

import fr.terrafunder.command.*;
import fr.terrafunder.event.*;
import fr.terrafunder.scoreboard.sbAll;
import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.WorldBorder;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class Terrafunder extends JavaPlugin {

    public static ConfigurationSection section;

    @Override
    public void onEnable()
    {
        Bukkit.broadcastMessage("§a-------- Terrafunder On ---------");
        getCommand("Launch").setExecutor(new commandLaunch());
        getCommand("Configure").setExecutor(new commandConfigure());
        getCommand("Alert").setExecutor(new commandAlert());
        getCommand("Addplayer").setExecutor(new commandAddPlayer());
        getCommand("Border").setExecutor(new commandBorder());
        getCommand("Chest").setExecutor(new commandCreateChest());
        getCommand("Day").setExecutor(new commandDay());
        getCommand("Rule").setExecutor(new commandRule());
        getServer().getPluginManager().registerEvents(new eventPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new eventPlayerChooseTeam(), this);
        getServer().getPluginManager().registerEvents(new eventChat(), this);
        getServer().getPluginManager().registerEvents(new eventFight(), this);
        getServer().getPluginManager().registerEvents(new eventDeath(), this);
        getServer().getPluginManager().registerEvents(new eventAntiCraft(), this);
        getServer().getPluginManager().registerEvents(new eventWin(), this);
        getServer().getPluginManager().registerEvents(new eventWeatherClear(), this);
        getServer().getPluginManager().registerEvents(new eventBreackEmerald(), this);
        getServer().getPluginManager().registerEvents(new GuiEvent(), this);
        getServer().getPluginManager().registerEvents(new eventCancelDeath(), this);
        saveDefaultConfig();
        WorldBorder worldBorder = Bukkit.getWorld("world").getWorldBorder();
        worldBorder.setSize(2000);
        section = getConfig().getConfigurationSection("team");
        super.onEnable();
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if(!player.isOp())
            {
                player.setGameMode(GameMode.ADVENTURE);
                player.setHealth(20);
                player.setFoodLevel(20);
                Inventory inventory = player.getInventory();
                inventory.clear();
            }
        }
        sbAll sbSpawn = new sbAll();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
        {
            @Override
            public void run()
            {
                sbSpawn.sb();
                for (Team team : MakeTeam.getTeams())
                {
                    for (UUID uuid : team.getUuids())
                    {
                        for (Player player : Bukkit.getOnlinePlayers())
                        {
                            if (player.getUniqueId().equals(uuid))
                            {
                                player.setPlayerListName(ChatColor.valueOf(team.getColor()) + player.getDisplayName());
                            }
                        }
                    }
                }
            }
        }, 0L, 20L);
    }

    @Override
    public void onDisable()
    {
        Bukkit.broadcastMessage("§c------- Terrafunder Off --------");
        super.onDisable();
    }
}