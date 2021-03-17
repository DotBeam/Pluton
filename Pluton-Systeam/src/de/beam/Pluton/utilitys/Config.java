package de.beam.Pluton.utilitys;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import de.beam.Pluton.Main.Main;

public class Config {
	
public static void CreateCfgs() {
		
		File file = new File(Main.main.getDataFolder(), "Mysql.yml");
	    if(!file.exists()) {
	    	Createmysqlcfg();
	    	Bukkit.getConsoleSender().sendMessage(SaveString.pr+"§c Bitte trage Deine Mysql Daten Ein");
	    	Bukkit.shutdown();
	    }
		CreateCfg();
		CreatePermission();
	}
	
	private static void Createmysqlcfg() {
		File file = new File(Main.main.getDataFolder(), "Mysql.yml");
	    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	    if(!file.exists()) {
	    	cfg.set("Mysql.Host", "localhost");
		    cfg.set("Mysql.Port", "3306");
		    cfg.set("Mysql.User", "root");
		    cfg.set("Mysql.Pass", "");
		    cfg.set("Mysql.Database", "");
		    try {
				cfg.save(file);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    }
	    
		
		
	}
	private static void CreatePermission() {
		File file = new File(Main.main.getDataFolder(), "Permission.yml");
	    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	    if(!file.exists()) {
	    	//Admin Permission
	    	cfg.set("Permission.Admin", "Pluton.Admin.*");
	    	cfg.set("Permission.pluton.add", "system.pluton.add");
	    	cfg.set("Permission.pluton.set", "system.pluton.set");
	    	cfg.set("Permission.pluton.seeme", "system.pluton.seeme");
	    	cfg.set("Permission.pluton.see", "system.pluton.seeothers");
	    	cfg.set("Permission.pluton.top", "system.pluton.top");
	    	cfg.set("Permission.pluton.reset", "system.pluton.reset");
	    	try {
				cfg.save(file);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    }
		
	}
	private static void CreateCfg() {
		File file = new File(Main.main.getDataFolder(), "Config.yml");
	    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	    if(!file.exists()) {
	    	cfg.set("Config.Prefix","§d§lPluton §8>> §7");
	    	cfg.set("Config.NoPermission","No Permission");
	    	cfg.set("Config.NoPlayer","No Player");
	    	cfg.set("Config.Pluton.CMD.Add.sender","DU hast denn Spieler {Spieler} {Menge} gegeben");
	    	cfg.set("Config.Pluton.CMD.Add.taget","DU hast {Menge} bekommen");
	    	cfg.set("Config.Pluton.CMD.Set","Du hast die Pluton von {Spieler} auf {Menge} gesetzt");
	    	cfg.set("Config.Pluton.CMD.seeme","Du hast {Menge}");
	    	cfg.set("Config.Pluton.CMD.see","Der Spieler {Spieler} hat {Menge}");
	    	cfg.set("Config.Pluton.CMD.reset","Du hast denn Spieler {Spieler} auf 0 gesetzt");

	    	cfg.set("Config.Pluton.CMD.pluton","§aSammle Pluton durch Votes und Werbung schauen um coole extras freizuschalten.");
	    	
	    	
	    	
		try {
			cfg.save(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	    }
	}

}
