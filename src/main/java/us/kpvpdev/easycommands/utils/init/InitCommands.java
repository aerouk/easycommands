package us.kpvpdev.easycommands.utils.init;

import us.kpvpdev.easycommands.commands.*;

public class InitCommands {

    public static void registerCommands() {
        new ClearInventory();
        new Feed();
        new Freeze();
        new Heal();
        new Help();
        new Weather();
    }

}
