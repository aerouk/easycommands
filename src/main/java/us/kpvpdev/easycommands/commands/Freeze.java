package us.kpvpdev.easycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.kpvpdev.easycommands.EasyCommands;
import us.kpvpdev.easycommands.utils.ChatHelper;
import us.kpvpdev.easycommands.utils.PlayerHelper;

public class Freeze implements CommandExecutor {

    public Freeze() {
        EasyCommands.getInstance().getCommand("freeze").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (PlayerHelper.checkPermission(sender, "easycommands.freeze")) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    if (EasyCommands.lists().frozen.contains(target.getName())) {
                        EasyCommands.lists().frozen.remove(target.getName());
                        ChatHelper.sendMsg(sender, true, target.getName() + " has been unfrozen.");
                    } else {
                        EasyCommands.lists().frozen.add(target.getName());
                        ChatHelper.sendMsg(sender, true, target.getName() + " has been frozen.");
                    }
                } else {
                    ChatHelper.sendPlayerNotFoundMessage(sender, args[0]);
                }
            } else {
                ChatHelper.sendNoPermsMsg(sender);
            }
        } else {
            ChatHelper.sendUsageMessage(sender, label, "<playerName>");
        }
        
        return false;
    }

}
