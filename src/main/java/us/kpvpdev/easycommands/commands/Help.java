package us.kpvpdev.easycommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import us.kpvpdev.easycommands.EasyCommands;
import us.kpvpdev.easycommands.utils.ChatHelper;
import us.kpvpdev.easycommands.utils.PlayerHelper;

public class Help implements CommandExecutor {

    public Help() {
        EasyCommands.getInstance().getCommand("echelp").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (PlayerHelper.checkPermission(sender, "easycommands.help")) {
                
            } else {
                
            }
        } else {
            ChatHelper.sendUsageMessage(sender, label, null);
        }

        return false;
    }

}
