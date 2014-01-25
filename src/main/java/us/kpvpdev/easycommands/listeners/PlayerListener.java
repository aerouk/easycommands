package us.kpvpdev.easycommands.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import us.kpvpdev.easycommands.EasyCommands;

public class PlayerListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (EasyCommands.lists().frozen.contains(event.getPlayer().getName())) {
            if(event.getFrom().getX() != event.getTo().getX() || event.getFrom().getZ() != event.getTo().getZ()) {
                event.setTo(event.getFrom());
            }
        }
    }

}
