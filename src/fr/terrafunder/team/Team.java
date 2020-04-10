package fr.terrafunder.team;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Team implements Listener
{
    private String name;
    private String id;
    private String color;
    private byte data;
    private List<UUID> uuids = new ArrayList<>();

    public Team (String Name, String Id, String Color, byte Data)
    {
        name = Name;
        id = Id;
        color = Color;
        data = Data;
    }

    public void addPlayer (UUID _uuid)
    {
        uuids.add(_uuid);
    }

    public void removePlayer (UUID _uuid)
    {
        uuids.remove(_uuid);
    }

    public List<UUID> getUuids()
    {
        return uuids;
    }

    public int getSize()
    {
        return uuids.size();
    }

    public String getName()
    {
        return name;
    }

    public String getColor()
    {
        return color;
    }

    public byte getData()
    {
        return data;
    }

    public String getId()
    {
        return id;
    }
}
