package fr.terrafunder.team;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String id;
    private String color;
    private byte data;
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
        ItemStack item = new ItemStack(Material.BANNER, 1, data);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.valueOf(color) + "Rejoignez la Team " + name);
        item.setItemMeta(itemMeta);
        return item;
    }

    public void addPlayer (Player _player)
    {
        player.add(_player);
    }

    public void rmPlayer (Player _player)
    {
        player.remove(_player);
    }

    public List<Player> getPlayer()
    {
        return player;
    }

    public int getSize()
    {
        return player.size();
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
