package us.kpvpdev.easycommands.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

/**
 * Contains methods to aid in the manipulation of a Player.
 */
public class PlayerHelper
{
    /**
     * Clears the inventory of the specified Player.
     *
     * @param player player to clear the inventory of
     */
    public static void clearPlayerInventory(Player player)
    {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        for (PotionEffect pot : player.getActivePotionEffects())
        {
            player.removePotionEffect(pot.getType());
        }
    }

    /**
     * Checks whether the CommandSender has the permission supplied or if they
     * are a server operator.
     *
     * @param sender sender to check the permissive status of
     * @param permission permission to check for
     * @return whether the player has the permission or operator status
     */
    public static boolean checkPermission(CommandSender sender, String permission)
    {
        return sender.hasPermission(permission) || sender.isOp();
    }
}
