package fr.terrafunder.event;

import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class eventChat implements Listener
{
    private String _color;

    @SuppressWarnings("deprecated")
    @EventHandler
    public void chatColor (PlayerChatEvent event)
    {
        _color = "WHITE";
        Player player = event.getPlayer();
        for (Team team : MakeTeam.getTeams())
        {
            if(team.getPlayer().contains(player))
            {
                _color = team.getColor();
            }
        }
        String _message = event.getMessage();
        event.setFormat(ChatColor.DARK_RED + "<- " + ChatColor.valueOf(_color) + player.getDisplayName() + ChatColor.DARK_RED + " -> : " + ChatColor.valueOf(_color) + _message);
    }
}
