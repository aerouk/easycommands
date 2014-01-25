package us.kpvpdev.easycommands;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import us.kpvpdev.easycommands.listeners.PlayerListener;
import us.kpvpdev.easycommands.utils.Lists;
import us.kpvpdev.easycommands.utils.init.InitCommands;

/**
 * EasyCommands - A Bukkit plugin to aid players and staff alike.
 *
 * @author iEpix
 * @version 0.0.1
 */
public class EasyCommands extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        easycommands = this;

        InitCommands.registerCommands();
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        easycommands = null;
        lists = null;
    }

    private static EasyCommands easycommands;
    private static Lists lists = new Lists();

    public static EasyCommands getInstance() {
        return easycommands;
    }

    public static Lists lists() {
        return lists;
    }

}
