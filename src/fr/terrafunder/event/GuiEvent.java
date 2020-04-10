package fr.terrafunder.event;

import fr.terrafunder.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiEvent implements Listener {

    public ItemStack choseteam() {

        ItemStack banner = new ItemStack(Material.BANNER, 1, Team.getData());
        ItemMeta itemMeta = banner.getItemMeta();
        itemMeta.setDisplayName(ChatColor.valueOf(Team.getColor()) + "Rejoignez la Team " + Team.getName());
        banner.setItemMeta(itemMeta);
        return banner;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();
        if (it == null) return;

        if (it.getType() == Material.CHEST && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6Sélecteur de team"))
        {
            Inventory inv = Bukkit.createInventory(null, 45, "§6Sélecteur de team");
            ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE,1);
            int i = 0;
            while (i < 10) {
                inv.setItem(i, glas);
                i++;
            }
            inv.setItem(17, glas);
            inv.setItem(18, glas);
            inv.setItem(26, glas);
            inv.setItem(27, glas);
            int j = 35;
            while (j < 45 )
            {
                inv.setItem(j, glas);
                j++;
            }
            inv.setItem(20, choseteam());
            player.openInventory(inv);

        }
    }
}
