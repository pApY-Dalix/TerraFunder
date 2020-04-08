package fr.terrafunder;

import fr.terrafunder.command.*;
import fr.terrafunder.event.*;
import fr.terrafunder.scoreboard.sbAll;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.WorldBorder;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

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
        saveDefaultConfig();
        WorldBorder worldBorder = Bukkit.getWorld("world").getWorldBorder();
        worldBorder.setSize(1500);
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