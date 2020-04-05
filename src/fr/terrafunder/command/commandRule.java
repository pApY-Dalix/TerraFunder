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
            if(commandSender instanceof Player)
            {
                if (args.length == 0)
                {
                    return false;
                }
                if(args[0] == "1")
                {
                    commandSender.sendMessage("§9-----------Page 1/?------------");
                    commandSender.sendMessage("> §3But : Récupérer le bloc §ad'émeraude §3qui se situe dans le château des défenseurs et le placer sur le bloc bedrock.");
                    commandSender.sendMessage("> §3Au minimum 1 §adéfenseur §3doit mourir (pvp) pour récupérer le bloc §ad'émeraude");
                    commandSender.sendMessage("> §3Au minimum 1 §adéfenseur §3doit mourir (pvp) pour récupérer le bloc §ad'émeraude");
                    commandSender.sendMessage("> §3Les §6défenseurs ont le droit de placer le bloc §ad'émeraude §3n'importe où dans le château, mais une face du bloc doit être visible");
                    commandSender.sendMessage("Les attaquants ne peuvent qu’attaquer à partir du §c§ljour 4 !");
                }
                if(args[0] == "2")
                {
                    commandSender.sendMessage("§9-----------Page 2/?------------");
                    commandSender.sendMessage("> §3Pvp activer jour 3");
                    commandSender.sendMessage("> §3Potion de force et Pomme de Noctch désactiver");
                    commandSender.sendMessage("> §3Bordure de map 1500 blocs. Réduit a 500 blocs jour 5");
                    commandSender.sendMessage("> §3Tous technique d'attaques sont autorisées");
                    commandSender.sendMessage("> §3Tous technique d'attaques sont autorisées");

                }
                if(args[0] == "3")
                {
                    commandSender.sendMessage("§9-----------Page 3/?------------");
                    commandSender.sendMessage("Chaque jour des coffres spawn a des cordonnée aléatoire");
                    commandSender.sendMessage("Friendly Fire désactiver");
                    commandSender.sendMessage("Les attaquants ont les droits de casser TOUS les blocs du château");
                    commandSender.sendMessage("Pas de limite de stuff");
                }
            }
        }


        return false;
    }
}
