package us.kpvpdev.easycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import us.kpvpdev.easycommands.EasyCommands;
import us.kpvpdev.easycommands.utils.ChatHelper;
import us.kpvpdev.easycommands.utils.PlayerHelper;

public class Heal implements CommandExecutor {

    public Heal() {
        EasyCommands.getInstance().getCommand("heal").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (PlayerHelper.checkPermission(sender, "easycommands.heal")) {
                    player.setHealth(player.getMaxHealth());
                    ChatHelper.sendMsg(sender, true, "You've been healed to full health.");
                } else {
                    ChatHelper.sendNoPermsMsg(sender);
                }
            } else {
                ChatHelper.sendPlayerOnlyMessage(sender);
            }
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("all")) {
                if (PlayerHelper.checkPermission(sender, "easycommands.heal.all")) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.setHealth(players.getMaxHealth());
                    }

                    ChatHelper.sendMsg(sender, true, "All players healed to full health!");
                } else {
                    ChatHelper.sendNoPermsMsg(sender);
                }
            } else {
                if (PlayerHelper.checkPermission(sender, "easycommands.heal.other")) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        target.setHealth(target.getMaxHealth());
                        ChatHelper.sendMsg(sender, true, "Healed " + target.getDisplayName() + " to maximum health.");
                    } else {
                        ChatHelper.sendPlayerNotFoundMessage(sender, args[0]);
                    }
                } else {
                    ChatHelper.sendNoPermsMsg(sender);
                }
            }
        } else {
            ChatHelper.sendUsageMessage(sender, label, "[playerName, all]");
        }

        return false;
    }

}
