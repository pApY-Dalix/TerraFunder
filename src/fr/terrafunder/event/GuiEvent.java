package fr.terrafunder.event;

import fr.terrafunder.team.MakeTeam;
import fr.terrafunder.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiEvent implements Listener {

    public ItemStack chooseteam() {

        for (Team team : MakeTeam.getTeams())
        {
            ItemStack banner = new ItemStack(Material.BANNER, 1, team.getData());
            ItemMeta itemMeta = banner.getItemMeta();
            itemMeta.setDisplayName(ChatColor.valueOf(team.getColor()) + "Rejoignez la Team " + team.getName());
            banner.setItemMeta(itemMeta);
            return (banner);
        }
        return null;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();
        if (it == null)
        {
            return;
        }
        if (it.getType() == Material.CHEST && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6Sélecteur de team"))
        {
            Inventory inv = Bukkit.createInventory(null, 45, "§6Sélecteur de team");
<<<<<<< Updated upstream
            ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE,1);
=======
            ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 8);
>>>>>>> Stashed changes
            int i = 0;
            while (i < 10) {
                inv.setItem(i, glass);
                i++;
            }
            inv.setItem(17, glass);
            inv.setItem(18, glass);
            inv.setItem(26, glass);
            inv.setItem(27, glass);
            int j = 35;
            while (j < 45 )
            {
                inv.setItem(j, glass);
                j++;
            }
<<<<<<< Updated upstream
            inv.setItem(20, chooseteam());
=======

            inv.setItem(20, choseteam());


>>>>>>> Stashed changes
            player.openInventory(inv);
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent event)
    {
        Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();
        if (current == null) return;
        if (inv.getName().equalsIgnoreCase("§6Sélecteur de team"))
        {
            event.setCancelled(true);
            if(current.getType() == Material.BANNER)
            {
                player.closeInventory();

            }
        }
    }
}
