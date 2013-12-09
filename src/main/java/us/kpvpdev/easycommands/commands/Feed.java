package us.kpvpdev.easycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.kpvpdev.easycommands.EasyCommands;
import us.kpvpdev.easycommands.utils.ChatHelper;
import us.kpvpdev.easycommands.utils.PlayerHelper;

public class Feed implements CommandExecutor
{
    public Feed()
    {
        EasyCommands.getInstance().getCommand("feed").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length == 0)
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;

                if (PlayerHelper.checkPermission(sender, "easycommands.feed"))
                {
                    player.setFoodLevel(20);
                    player.setSaturation(5F);
                    ChatHelper.sendMsg(sender, true, "You've been fed to full hunger.");
                }
                else
                {
                    ChatHelper.sendNoPermsMsg(sender);
                }
            }
            else
            {
                ChatHelper.sendPlayerOnlyMessage(sender);
            }
        }
        else if (args.length >= 1)
        {
            if (PlayerHelper.checkPermission(sender, "easycommands.feed.other"))
            {
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null)
                {
                    target.setFoodLevel(20);
                    ChatHelper.sendMsg(sender, true, "Fed " + target.getDisplayName() + ".");
                }
                else
                {
                    ChatHelper.sendPlayerNotFoundMessage(sender, args[0]);
                }
            }
            else
            {
                ChatHelper.sendNoPermsMsg(sender);
            }
        }

        return false;
    }
}
