package us.kpvpdev.easycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.kpvpdev.easycommands.EasyCommands;
import us.kpvpdev.easycommands.utils.ChatHelper;
import us.kpvpdev.easycommands.utils.PlayerHelper;

public class ClearInventory implements CommandExecutor {

    public ClearInventory() {
        EasyCommands.getInstance().getCommand("clearinventory").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (PlayerHelper.checkPermission(sender, "easycommands.clearinventory")) {
                    PlayerHelper.clearPlayerInventory(player);
                    ChatHelper.sendMsg(sender, true, "Your inventory has been cleared!");
                } else {
                    ChatHelper.sendNoPermsMsg(sender);
                }
            } else {
                ChatHelper.sendPlayerOnlyMessage(sender);
            }
        } else if (args.length == 1) {
            if (PlayerHelper.checkPermission(sender, "easycommands.clearinventory.other")) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    PlayerHelper.clearPlayerInventory(target);
                    ChatHelper.sendMsg(sender, true, "Cleared " + target.getDisplayName() + "'s inventory.");
                } else {
                    ChatHelper.sendPlayerNotFoundMessage(sender, args[0]);
                }
            } else {
                ChatHelper.sendNoPermsMsg(sender);
            }
        } else {
            ChatHelper.sendUsageMessage(sender, label, "[playerName]");
        }

        return false;
    }

}
