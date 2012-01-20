package me.dina002.Weather;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class WeatherCommandExecutor implements CommandExecutor {
	Weather plugin;

	public WeatherCommandExecutor(Weather instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		World world = null;
		Player player = (Player) sender;
		if (player.hasPermission("Weather.sky")){
		if (sender instanceof Player) {
			if (args.length == 2) {
				world = Bukkit.getWorld(args[1]);
			} else {
				world = ((Player) sender).getWorld();
			}
		} else if (sender instanceof ConsoleCommandSender) {
			if (args.length == 2) {
				world = Bukkit.getWorld(args[1]);
			} else {
				sender.sendMessage("Write in the World Name!");
				return false;
			}
		}

		if (args.length >= 1 && world != null) {
			if (args[0].equalsIgnoreCase("sun")) {
				world.setStorm(false);
				player.getServer().broadcastMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.GREEN + " Ghanged the Weather to Sun");
				return true;
			} else if (args[0].equalsIgnoreCase("rain")) {
				world.setStorm(true);
				player.getServer().broadcastMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.GREEN + " Ghanged the Weather to Rain");
				return true;
			} else if (args[0].equalsIgnoreCase("storm")) {
				world.setStorm(true);
				world.setThundering(true);
				player.getServer().broadcastMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.GREEN + " Ghanged the Weather to Storm");
				return true;
			}
		}

		return false;
	}
		return false;
	}
}