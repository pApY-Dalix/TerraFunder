package fr.terrafunder.team;

import fr.terrafunder.Terrafunder;
import fr.terrafunder.command.commandLaunch;
import fr.terrafunder.event.eventDeath;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MakeTeam
{
    private static List<Team> teams = new ArrayList<>();
    public static boolean verificationTeam = false;

    public static void addPlayer(Player player, Team team)
    {
        player.setPlayerListName(ChatColor.valueOf(team.getColor()) + player.getDisplayName());
        team.addPlayer(player, player.getUniqueId());
        player.sendMessage( ChatColor.valueOf(team.getColor()) + "Vous êtes attribué(e) à la team : " + team.getName());
        player.sendMessage( ChatColor.valueOf(team.getColor()) + "Nombre de player dans cette team : " + team.getSize());
    }

    public static void rmPlayer(Player player, UUID uuid)
    {
        for (Team team : teams)
        {
            if (team.getPlayer().contains(player) && team.getUuids().contains(uuid))
            {
                team.rmPlayer(player, uuid);
                Bukkit.broadcastMessage("Suppression Effectué");
            }
        }
    }

    public static void CreateTeam()
    {
        ConfigurationSection section = Terrafunder.section;
        resetTeam();
        int i = 0;
        for (String _team : section.getKeys(false))
        {
            String name = section.getString(_team + ".name");
            String id = section.getString(_team + ".name");
            if (i != 0)
            {
                name = name + " " + i;
                id += i;
            }
            String color = section.getString(_team + ".color");
            byte data = (byte)section.getInt(_team + ".data");
            Bukkit.broadcastMessage(name + "/" + color + "/" + data);
            teams.add(new Team(name, id, color, data));
            i++;
        }
        verificationTeam = true;
        Bukkit.broadcastMessage("Nombre de team : " + teams.size());
    }

    public static List<Team> getTeams()
    {
        return teams;
    }

    public static void resetTeam()
    {
        teams.clear();
        for (Player player : Bukkit.getOnlinePlayers())
        {
            player.setPlayerListName(ChatColor.WHITE + player.getDisplayName());
        }
        verificationTeam = false;
    }

    public static int nbAttaquant()
    {
        int nb = 0;
        for (Team team : teams)
        {
            if (team.getData() != 14)
            {
                nb += team.getSize();
            }
        }
        if (nb == 0 && commandLaunch.Launch)
        {
            commandLaunch.stop();
            Bukkit.broadcastMessage("§c§l> [SERVEUR] LES DEFENSEURS ONT GAGNER !");
        }
        return nb;
    }

    public static int nbDefender()
    {
        int nb = 0;
        for (Team team : teams)
        {
            if (team.getData() == 14)
            {
                nb += team.getSize();
            }
        }
        if (nb == 0 && commandLaunch.Launch && !eventDeath.defenderDeath)
        {
            eventDeath.defenderDeath = true;
            Bukkit.broadcastMessage("§c§l> [SERVEUR] §cLes §f§lAttaquants §cpeuvent prendre le bloc                 §ad'émeraude !");
        }
        return nb;
    }
}
