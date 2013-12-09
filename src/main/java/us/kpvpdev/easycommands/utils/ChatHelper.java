package us.kpvpdev.easycommands.utils;

import org.bukkit.command.CommandSender;

/**
 * Contains methods to make sending messages easier.
 */
public class ChatHelper
{
    /**
     * Sends a message to the defined player.
     *
     * @param sender CommandSender to send the message to
     * @param prefix whether to add a prefix to the message
     * @param msg message to send to the player
     */
    public static void sendMsg(CommandSender sender, boolean prefix, String msg)
    {
        if (prefix)
        {
            msg = "§bEC §7> §r" + msg;
        }

        sender.sendMessage(msg);
    }

    /**
     * Sends a message to the player with a permission denied message.
     *
     * @param sender CommandSender to send the message to
     */
    public static void sendNoPermsMsg(CommandSender sender)
    {
        sendMsg(sender, false, "§cYou were denied access to execute that command.");
    }

    /**
     * Sends a message to the CommandSender with a message informing them that
     * the command must be executed in-game.
     *
     * @param sender CommandSender to send the message to
     */
    public static void sendPlayerOnlyMessage(CommandSender sender)
    {
        sendMsg(sender, false, "§cThis command can only be used by an in-game player.");
    }

    /**
     * Sends a message to the CommandSender with a message informing them that
     * the player supplied could not be found on the server.
     *
     * @param sender CommandSender to send the message to
     * @param player Player name to check for
     */
    public static void sendPlayerNotFoundMessage(CommandSender sender, String player)
    {
        sendMsg(sender, true, "Player §3" + player + "§r not found.");
    }
}
