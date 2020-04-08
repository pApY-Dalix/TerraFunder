package fr.terrafunder.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandRule implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("Rule"))
        {
            if (args.length == 0)
            {
                return false;
            }
            if(args[0].equalsIgnoreCase("1"))
            {
                commandSender.sendMessage("§9-----------Page 1/3------------");
                commandSender.sendMessage("> §3But : Récupérer le bloc §ad'émeraude §3qui se situe dans le château des §6défenseurs §3et le placer sur le bloc §7bedrock.");
                commandSender.sendMessage("> §3Au minimum 1 §adéfenseur §3doit mourir (pvp) pour récupérer le bloc §ad'émeraude");
                commandSender.sendMessage("> §3Les §6défenseurs §3ont le droit de placer le bloc §ad'émeraude         §3n'importe où dans le château, mais une §6face §3du §bbloc doit être visible");
                commandSender.sendMessage("> §3Les §f§lattaquants §3ne peuvent qu’attaquer à partir du §c§ljour 4 !");
                return true;
            }
            if(args[0].equalsIgnoreCase("2"))
            {
                commandSender.sendMessage("§9-----------Page 2/3------------");
                commandSender.sendMessage("> §3Pvp activer §c§ljour 3");
                commandSender.sendMessage("> §3Potion de §4force §3et §dPomme de Noctch §cdésactiver");
                commandSender.sendMessage("> §3Bordure de map §c1500 §fblocs. §cRéduit §3a 500 blocs §cjour 5");
                commandSender.sendMessage("> §3Tous technique d'attaques sont autorisées");
                return true;

            }
            if(args[0].equalsIgnoreCase("3"))
            {
                commandSender.sendMessage("§9-----------Page 3/3------------");
                commandSender.sendMessage("> §3Chaque jour des coffres spawn a des cordonnées §6aléatoire");
                commandSender.sendMessage("> §3Friendly Fire §cdésactiver");
                commandSender.sendMessage("> §3Les §f§lattaquants §3ont les droits de casser §aTOUS les blocs du château");
                commandSender.sendMessage("> §3Pas de §alimite §3de stuff");
                return true;
            }
        }
        return false;
    }

}
