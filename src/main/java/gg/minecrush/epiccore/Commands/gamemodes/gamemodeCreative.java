package gg.minecrush.epiccore.Commands.gamemodes;

import gg.minecrush.epiccore.DataStorage.yaml.Config;
import gg.minecrush.epiccore.DataStorage.yaml.Lang;
import gg.minecrush.epiccore.Util.color;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemodeCreative implements CommandExecutor {
    Lang lang;
    Config config;

    public gamemodeCreative(Lang lang, Config config) {
        this.lang = lang;
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            if (!sender.hasPermission(config.getValue("gmc-command-permission"))){
                sender.sendMessage(lang.getReplacedMessage("no-permission"));
                return false;
            }

            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(lang.getReplacedMessage("updated-gamemode").replace("%gamemode%", "creative"));
                player.setGameMode(GameMode.CREATIVE);
            } else {
                player.sendMessage(lang.getReplacedMessage("invalid-arguments").replace("%invalid-arguments%", "/gmc"));
            }
        } else {
            sender.sendMessage(color.c("&cConsole cannot execute this command!"));
        }
        return true;
    }
}
