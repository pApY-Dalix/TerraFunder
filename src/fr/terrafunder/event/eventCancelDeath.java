package fr.terrafunder.event;

import fr.terrafunder.scoreboard.sbAll;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class eventCancelDeath implements Listener {

    public void cancelDeath(EntityDamageEvent event)
    {
        Player player = (Player) event;
        if (sbAll.day < 3)
        {
            Bukkit.broadcastMessage("§cWwo tu est dans le if n 1 !!");
            if (player instanceof Player)
            {
                Bukkit.broadcastMessage("§eWwo tu est dans le if n 2 !!");

                if (event.getFinalDamage() >= player.getHealth())
                {
                    event.setCancelled(true);
                    Bukkit.broadcastMessage("§aWwo tu est dans le if 3 !!");
                    return;
                }
            }

        }

    }


}
