package us.kpvpdev.easycommands;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import us.kpvpdev.easycommands.utils.init.InitCommands;

public class EasyCommands extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        easycommands = this;

        InitCommands.registerCommands();
    }

    @Override
    public void onDisable()
    {
        
    }

    private static EasyCommands easycommands;

    public static EasyCommands getInstance()
    {
        return easycommands;
    }
}
