package me.dina002.Weather;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class Weather extends JavaPlugin{
	Logger log = Logger.getLogger("Minecraft");
	
	
	
	public void onEnable(){
		log.info("Weather plugin has been activated");
		getCommand("sky").setExecutor(new WeatherCommandExecutor(this));
	}
	
	public void onDisable(){
		log.info("Weather plugin has been deactivated");
		
	}
	
}
