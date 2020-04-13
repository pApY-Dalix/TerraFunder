package fr.terrafunder.event;

import fr.terrafunder.scoreboard.sbAll;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class eventCancelDeath implements Listener {

    public void cancelDeath(EntityDamageEvent event)
    {
        Player player = (Player) event;
        if (sbAll.day < 3)
        {
            if (event.getFinalDamage() >= player.getHealth())
            {
                event.setCancelled(true);
                Random rand = new Random();
                World world = Bukkit.getWorld("world");
                int _coord = (int) world.getWorldBorder().getSize() / 2;
                int x = rand.nextInt(_coord);
                int z = rand.nextInt(_coord);
                int y = world.getHighestBlockYAt(x, z);
                player.setHealth(18);
                player.setMaxHealth(18);
                Location respawn = new Location(world, x, y, z);
                player.teleport(respawn);
                player.sendMessage("§a>[SERVEUR] Le bon dieu vous fait grâce de votre mort mais vous perdez 2 coeurs permanent :)");
                return;
            }
        }
    }
}
