package fr.terrafunder.team;

import org.bukkit.Material;
import org.bukkit.entity.Player;
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
    private List<Player> player = new ArrayList<>();


    public Team (String Name, String Id, String Color, byte Data)
    {
        name = Name;
        id = Id;
        color = Color;
        data = Data;
    }


    public ItemStack getTeam()
    {
        ItemStack chesteam = new ItemStack(Material.CHEST,1);
        ItemMeta cChest = chesteam.getItemMeta();
        cChest.setDisplayName("§6Sélecteur de team");
        chesteam.setItemMeta(cChest);
        return chesteam;
    }

    public void addPlayer (Player _player, UUID _uuid)
    {
        player.add(_player);
        uuids.add(_uuid);
    }

    public void rmPlayer (Player _player, UUID _uuid)
    {
        player.remove(_player);
        uuids.remove(_uuid);
    }

    public  List<Player> getPlayer()
    {
        return player;
    }

    public List<UUID> getUuids()
    {
        return uuids;
    }

    public int getSize()
    {
        return player.size();
    }

    public  String getName()
    {
        return name;
    }

    public  String getColor()
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
