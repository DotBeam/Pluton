package de.beam.Pluton.utilitys;

import org.bukkit.entity.Player;

import de.beam.Pluton.Api.FileManager;

public class SaveString {
	
	
	public static String pr = FileManager.getString("Config", "Config.Prefix");
	
	//Permision
	public static String adminpermission = FileManager.getString("Permission", "Permission.Admin");
	public static String Plutonadd = FileManager.getString("Permission", "Permission.pluton.add");
	public static String Plutonset = FileManager.getString("Permission", "Permission.pluton.set");
	public static String Plutonseeme = FileManager.getString("Permission", "Permission.pluton.seeme");
	public static String Plutonsee = FileManager.getString("Permission", "Permission.pluton.see");
	public static String PlutonTop = FileManager.getString("Permission", "Permission.pluton.top");
	public static String Plutonreset = FileManager.getString("Permission", "Permission.pluton.reset");
	
	
	//MSG
	public static String noPermission =  pr+FileManager.getString("Config", "Config.NoPermission");
	public static String NoPlayer =  pr+FileManager.getString("Config", "Config.NoPlayer");
	public static String Plutoncmdadd(Player player,int menge) {return pr+FileManager.getString("Config", "Config.Pluton.CMD.Add.sender").replace("{Spieler}", player.getName()).replace("{Menge}", ""+menge);}
	public static String Plutoncmdaddget(int menge) {return pr+FileManager.getString("Config", "Config.Pluton.CMD.Add.taget").replace("{Menge}", ""+menge);}
	public static String Plutoncmdset(Player player,int menge) {return pr+FileManager.getString("Config", "Config.Pluton.CMD.Set").replace("{Menge}", ""+menge).replace("{Spieler}", player.getName());}
	public static String Plutoncmdseeme(int menge) {return pr+FileManager.getString("Config", "Config.Pluton.CMD.seeme").replace("{Menge}", ""+menge);}
	public static String Plutoncmdsee(Player player,int menge) {return pr+FileManager.getString("Config", "Config.Pluton.CMD.see").replace("{Menge}", ""+menge).replace("{Spieler}", player.getName());}
	public static String Plutoncmdreset(Player player) {return pr+FileManager.getString("Config", "Config.Pluton.CMD.reset").replace("{Spieler}", player.getName());}
	
	public static String plutonhelp = pr+FileManager.getString("Config", "Config.Pluton.CMD.pluton");
	
}
