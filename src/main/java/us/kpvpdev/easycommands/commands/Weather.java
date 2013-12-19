package us.kpvpdev.easycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.kpvpdev.easycommands.EasyCommands;
import us.kpvpdev.easycommands.utils.ChatHelper;
import us.kpvpdev.easycommands.utils.PlayerHelper;

public class Weather implements CommandExecutor {

    public Weather() {
        EasyCommands.getInstance().getCommand("weather").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (PlayerHelper.checkPermission(sender, "easycommands.weather")) {
                if (args[0].equalsIgnoreCase("sun") || args[0].equalsIgnoreCase("clear")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        
                        player.getWorld().setStorm(false);
                        player.getWorld().setThundering(false);
                        ChatHelper.sendMsg(sender, true, "Weather set to §3sun§r in world §3" + player.getWorld().getName() + "§r.");
                    } else {
                        ChatHelper.sendMsg(sender, true, "Please specify a world to set the weather in.");
                    }
                } else if (args[0].equalsIgnoreCase("storm") || args[0].equalsIgnoreCase("rain")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        
                        player.getWorld().setStorm(true);
                        ChatHelper.sendMsg(sender, true, "Weather set to §3storm§r in world §3" + player.getWorld().getName() + "§r.");
                    } else {
                        ChatHelper.sendMsg(sender, true, "Please specify a world to set the weather in.");
                    }
                } else {
                    ChatHelper.sendUsageMessage(sender, label, "<sun, storm> [worldName]");
                }
            } else {
                ChatHelper.sendNoPermsMsg(sender);
            }
        } else if (args.length == 2) {
            if (args[1].equalsIgnoreCase("all") && args[0].equalsIgnoreCase("sun")) {
                if (PlayerHelper.checkPermission(sender, "easycommands.weather.all")) {
                    for (World world : Bukkit.getWorlds()) {
                        world.setStorm(false);
                        world.setThundering(false);
                    }

                    ChatHelper.sendMsg(sender, true, "Weather set to §3sun§r in all worlds.");
                } else {
                    ChatHelper.sendNoPermsMsg(sender);
                }
            } else if (args[1].equalsIgnoreCase("all") && args[0].equalsIgnoreCase("storm")) {
                if (PlayerHelper.checkPermission(sender, "easycommands.weather.all")) {
                    for (World world : Bukkit.getWorlds()) {
                        world.setStorm(true);
                    }

                    ChatHelper.sendMsg(sender, true, "Weather set to §3storm§r in all worlds.");
                } else {
                    ChatHelper.sendNoPermsMsg(sender);
                }
            } else {
                World world = Bukkit.getWorld(args[1]);
                
                if (world != null) {
                    if (PlayerHelper.checkPermission(sender, "easycommands.weather.world")) {
                        if (args[0].equalsIgnoreCase("sun")) {
                            world.setStorm(false);
                            world.setThundering(false);
                            ChatHelper.sendMsg(sender, true, "Weather set to §3sun§r in world §3" + world.getName() + "§r.");
                        } else if (args[0].equalsIgnoreCase("storm")) {
                            world.setStorm(true);
                            ChatHelper.sendMsg(sender, true, "Weather set to §3sun§r in world §3" + world.getName() + "§r.");
                        } else {
                            ChatHelper.sendUsageMessage(sender, label, "<sun, storm> [world]");
                        }
                    } else {
                        ChatHelper.sendNoPermsMsg(sender);
                    }
                } else {
                    ChatHelper.sendMsg(sender, true, "That world name is invalid. Please try again.");
                }
            }
        } else {
            ChatHelper.sendUsageMessage(sender, label, "<sun, storm> [world]");
        }
        
        return false;
    }

}
