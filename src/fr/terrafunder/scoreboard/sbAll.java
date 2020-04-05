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
            Score NbDef = panel.getScore("§6Defender > " + MakeTeam.nbDefender());

            if (commandLaunch.Launch && !etatGames)
            {
                i = 0;
                l = 0;
                day = 1;
                tick = 20;
                etatGames = true;
                player.setStatistic(Statistic.PLAYER_KILLS, 0);
            }
            else if (!commandLaunch.Launch && etatGames)
            {
                i = 0;
                l = 0;
                day = 1;
                tick = 20;
                etatGames = false;
            }

            if (l < 10 && i < 10)
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
            for (Team team : MakeTeam.getTeams())
            {
                if (team.getPlayer().contains(player))
                {
                    _Team = panel.getScore(ChatColor.valueOf(team.getColor()) + team.getName() + " > " +(String.valueOf(team.getSize())));
                }
            }

            if (l >= tick)
            {
                day++;
                tick += 20;
            }
            if (oldDay != day)
            {
                World world = Bukkit.getWorld("world");
                Bukkit.broadcastMessage("§b§l------Fin du jour " + day + "-------");
                lootChest.chest();
                world.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0F,1.0F);
                if (day == 2)
                {
                    Bukkit.broadcastMessage("§c§l------PVP Actif-------");
                }
                if (day == 4)
                {
                    Bukkit.broadcastMessage("§c§l------Attaque du Chateau Disponible-------");
                }
                if (day == 5)
                {
                    Bukkit.broadcastMessage("§c§l------La Border Réduit-------");
                    border.borderCreate(500, world);
                }
                oldDay = day;
            }
            Separate.setScore(9);
            if (!etatGames)
            {
                Info.setScore(8);
            }
            else
            {
                Kill.setScore(8);
            }
            Separated.setScore(7);
            Timer.setScore(6);
            Jours.setScore(5);
            Separateed.setScore(4);
            _Team.setScore(3);
            NbAttak.setScore(2);
            NbDef.setScore(1);

            player.setScoreboard(scoreboard);
        }
        i++;
    }
}
