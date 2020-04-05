package fr.terrafunder.other;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;

public class theBorder
{
    private double coordBorder;

    public void borderCreate(int _coord, World _world)
    {
        WorldBorder worldBorder = _world.getWorldBorder();
        worldBorder.setCenter(0, 0);
        coordBorder = worldBorder.getSize();
        long time;
        if (coordBorder < _coord)
        {
            time = (long) (_coord - coordBorder);
        }
        else
        {
            time = (long) (coordBorder - _coord);
        }
        worldBorder.setSize(_coord, time);

        Bukkit.broadcastMessage("§c§l> [SERVEUR] La bordure bouge vers " + _coord/2);
    }
}