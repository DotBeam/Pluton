package de.beam.Pluton.Main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	
	public static Main main;
	
	
	@Override
    public void onEnable() {
    	main = this;
    	
    	Register.Starter();
    	
    }
	
}
