package fr.terrafunder.scoreboard;

import fr.terrafunder.command.commandLaunch;
import fr.terrafunder.other.lootChest;
import fr.terrafunder.other.theBorder;
import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class sbAll
{
    private int i = 0;
    public static int l = 0;
    public static int day = 1;
    private int oldDay = 1;
    private int tick = 20;
    private boolean etatGames = false;
    private theBorder border = new theBorder();

    public void sb()
    {
        for (Player player : Bukkit.getOnlinePlayers())
        {
            ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

            Objective panel = scoreboard.registerNewObjective("Info", "dummy");

            panel.setDisplaySlot(DisplaySlot.SIDEBAR);
            panel.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "§lTerraFunder");

            if (i >= 60)
            {
                i = 0;
                l++;
            }

            Score Separate = panel.getScore("                       ");
            Score Separateed = panel.getScore("           ");
            Score Separated = panel.getScore(" ");

            Score Kill = panel.getScore(ChatColor.DARK_RED + "Kill > " + player.getStatistic(Statistic.PLAYER_KILLS));
            Score Jours = panel.getScore( ChatColor.DARK_AQUA + "Day > " + day);
            Score _Team = panel.getScore(ChatColor.MAGIC + "No Team");
            Score Info = panel.getScore(ChatColor.DARK_RED + "Online > " + Bukkit.getOnlinePlayers().size());
            Score Timer;
            Score NbAttak = panel.getScore("§lAttaquant > " + MakeTeam.nbAttaquant());
            Score NbDef = panel.getScore("§6Defenseur > " + MakeTeam.nbDefender());

            if (commandLaunch.Launch && !etatGames) //Si la commande "Launch" est true et que l'état de la game est false.
            {
                i = 0;  //Définie la variable "i" à 0.
                l = 0;  //Définie la variable "l" à 0.
                day = 1;    //Définie la variable "day" à 1.
                tick = 20;  //Définie la variable "tick" à 20.
                etatGames = true;  //Définie la variable "etatGames" à true.
                player.setStatistic(Statistic.PLAYER_KILLS, 0); //Définie les kills du player à 0.
            }
            else if (!commandLaunch.Launch && etatGames)    //Sinon si la commande "Launch" est false et que l'état de la game est true.
            {
                i = 0;  //Définie la variable "i" à 0.
                l = 0;  //Définie la variable "l" à 0.
                day = 1;    //Définie la variable "day" à 1.
                tick = 20;  //Définie la variable "tick" à 20.
                etatGames = false;  //Définie la variable "etatGames" à false.
            }

            if (l < 10 && i < 10)   //Permet d'afficher le temps en fonction selon l'ordre besoin.
            {
                Timer = panel.getScore(ChatColor.DARK_AQUA + "Timer > 0" + l + ":0" + i);

            }
            else if (l >= 10 && i < 10)
            {
                Timer = panel.getScore(ChatColor.DARK_AQUA + "Timer > " + l + ":0" + i);
            }
            else if (l < 10 && i >= 10)
            {
                Timer = panel.getScore(ChatColor.DARK_AQUA + "Timer > 0" + l + ":" + i);
            }
            else
            {
                Timer = panel.getScore(ChatColor.DARK_AQUA + "Timer > " + l + ":" + i);
            }
            for (Team team : MakeTeam.getTeams())   //Vérification team par team.
            {
                if (team.getUuids().contains(player.getUniqueId())) //Vérifie si le ID du player appartient à une team.
                {
                    _Team = panel.getScore(ChatColor.valueOf(team.getColor()) + team.getName() + " > " +(String.valueOf(team.getSize()))); //Permet d'afficher la team du player.
                }
            }

            if (l >= tick)  //Si le nombre de minutes est supérieur ou égal à la variable "tick".
            {
                day++;  //Incrémente +1 à la variable "day".
                tick += 20; //Incrémente +20 à la variable "tick".
            }
            if (oldDay != day)  //Si le jour actuelle est différent du jour sauvegardé
            {
                World world = Bukkit.getWorld("world"); //Récupère dans une variable le nom du monde "World".
                Bukkit.broadcastMessage("§b------ Fin du jour " + day + " -------");    //Création d'un message d'avertissement global avec le nombre de jours.
                Bukkit.broadcastMessage("  ");  //Création d'un message d'espacement.
                if (commandLaunch.Launch)   //Si la game est lancé.
                {
                    lootChest.chest();  //Création d'un coffre.
                }
                world.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0F,1.0F);   //Création d'un son global de type "Chat" lors d'un nouveau jour.
                if (day == 3)   //Si le jour est égal à 3
                {
                    Bukkit.broadcastMessage("§c------ PVP Actif -------");  //Création d'un message d'avertissement global.
                    Bukkit.broadcastMessage("  ");  //Création d'un message d'espacement.
                }
                if (day == 4)   //Si le jour est égal à 4.
                {
                    Bukkit.broadcastMessage("§c------ Attaque du Château Disponible -------");  //Création d'un message d'avertissement global.
                    Bukkit.broadcastMessage("  ");  //Création d'un message d'espacement.
                }
                if (day == 5)   //Si le jour est égal à 5.
                {
                    Bukkit.broadcastMessage("§c------ La Border Réduit -------");   //Création d'un message d'avertissement global.
                    Bukkit.broadcastMessage("  ");  //Création d'un message d'espacement.
                    border.borderCreate(300, world);    //Déplacement de la bordure du monde "World" en 300 blocs de diamètre.
                }
                oldDay = day;   //Récupération du jour dans une variable de sauvegarde.
            }
            Separate.setScore(9);   //Ajoute le score "Separate" au niveau 9.
            if (!etatGames) //Si l'état de la game est false.
            {
                Info.setScore(8);   //Ajoute le score "Info" au niveau 8.
            }
            else    //Sinon.
            {
                Kill.setScore(8);   //Ajoute le score "Kill" au niveau 8.
            }
            Separated.setScore(7);  //Ajoute le score "Separated" au niveau 7.
            Timer.setScore(6);  //Ajoute le score "Timer" au niveau 6.
            Jours.setScore(5);  //Ajoute le score "Jours" au niveau 5.
            Separateed.setScore(4); //Ajoute le score "Separateed" au niveau 4.
            _Team.setScore(3);  //Ajoute le score "_Team" au niveau 3.
            NbAttak.setScore(2);    //Ajoute le score "NbAttack" au niveau 2.
            NbDef.setScore(1);  //Ajoute le score "NbDef" au niveau 1.

            player.setScoreboard(scoreboard);   //Ajoute le scoreboard au player.
        }
        i++;    //Incrémente +1 à la variable "i".
    }
}
