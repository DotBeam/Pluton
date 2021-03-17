package de.beam.Pluton.Api;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import de.beam.Pluton.Main.Main;
import de.beam.Pluton.utilitys.SaveString;



public class FileManager {


    //set  
    public static void set(final String File ,final String name, final String value) {
    File file = new File(Main.main.getDataFolder(), File+".yml");
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    	  cfg.set(name, value);
          saveconfing(file);
           return;
    }
    //Save
    public static void saveconfing(final File File) {
    	 YamlConfiguration cfg = YamlConfiguration.loadConfiguration(File);
    	  try{

              cfg.save(File);

          }catch (IOException e) {
              e.printStackTrace();
              Bukkit.getConsoleSender().sendMessage(SaveString.pr+"§cFehler beim Speichern der LocationFile!");
          }
          return;
    }
	
    public static int getint(final String File,final String name) {
    	File file = new File(Main.main.getDataFolder(), File+".yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        
        return cfg.getInt(name);
    }
    
    public static String getString(final String File,final String name) {
    	File file = new File(Main.main.getDataFolder(), File+".yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        
        return cfg.getString(name);
    }
    public static boolean getBool(final String File,final String name) {
    	File file = new File(Main.main.getDataFolder(), File+".yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        return cfg.getBoolean(name);
    }
    
}
