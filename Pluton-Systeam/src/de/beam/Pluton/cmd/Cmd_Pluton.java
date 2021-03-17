package de.beam.Pluton.cmd;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.beam.Pluton.Mysql.Mysql_Pluton;
import de.beam.Pluton.utilitys.SaveString;

public class Cmd_Pluton implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String arg2, String[] args) {
		Player player = (Player) cs;
		
		if(args.length == 0) {
			
			
			player.sendMessage(SaveString.plutonhelp);
			if(player.hasPermission(SaveString.adminpermission)) {
				player.sendMessage(SaveString.pr+"/pluton see <Spieler> Läst Dich die Pluton(s) sehen");
				player.sendMessage(SaveString.pr+"/pluton top Zeigt die Die top 10 Spieler");
				player.sendMessage(SaveString.pr+"/pluton reset <Spieler> Stezt die Plutons von denn Spieler zurück");
				player.sendMessage(SaveString.pr+"/pluton add <Spieler> <Menge> hügt denn Spieler Plutons hinzu");
				player.sendMessage(SaveString.pr+"/pluton set <Spieler> <Menge> setzt die Plutons auf die menge die du angeben hast");
			}
			if(player.hasPermission(SaveString.Plutonadd)) {
				player.sendMessage(SaveString.pr+"/pluton add <Spieler> <Menge> hügt denn Spieler Plutons hinzu");
			}
			if(player.hasPermission(SaveString.Plutonset)) {
				player.sendMessage(SaveString.pr+"/pluton set <Spieler> <Menge> setzt die Plutons auf die menge die du angeben hast");
			}
			if(player.hasPermission(SaveString.Plutonreset)) {
				player.sendMessage(SaveString.pr+"/pluton reset <Spieler> Stezt die Plutons von denn Spieler zurück");
			}
			if(player.hasPermission(SaveString.PlutonTop)) {
				player.sendMessage(SaveString.pr+"/pluton top Zeigt die Die top 10 Spieler");
			}
			if(player.hasPermission(SaveString.Plutonseeme)) {
				player.sendMessage(SaveString.pr+"/pluton see Läst Dich deine Pluton(s) sehen");
			}
			if(player.hasPermission(SaveString.Plutonsee)) {
				player.sendMessage(SaveString.pr+"/pluton see <Spieler> Läst Dich die Pluton(s) sehen");
			}
			
			
			//Help
			
			
		}else if(args.length == 1) {
			if(player.hasPermission(SaveString.adminpermission)||player.hasPermission(SaveString.Plutonseeme)) {
			if(args[0].equalsIgnoreCase("see")) {
				player.sendMessage(SaveString.Plutoncmdseeme(Mysql_Pluton.getPluton(player.getUniqueId().toString())));
			}
			
			}else {player.sendMessage(SaveString.NoPlayer);}
			if(player.hasPermission(SaveString.adminpermission)||player.hasPermission(SaveString.PlutonTop)) {
				if(args[0].equalsIgnoreCase("top")) {
					HashMap<String, Integer> map =  Mysql_Pluton.top10();
					for (String i : map.keySet()) {
					      player.sendMessage(SaveString.pr+i+" hat "+map.get(i));
					    }
					
					
					
				}
				
				
			}else {player.sendMessage(SaveString.NoPlayer);}
			
			
		}else if(args.length == 2) {
			if(player.hasPermission(SaveString.adminpermission)||player.hasPermission(SaveString.Plutonsee)) {
				if(args[0].equalsIgnoreCase("see")) {
					//pluton see Player
					if(Bukkit.getServer().getPlayer(args[1])!= null) {
						Player tagetPlayer = Bukkit.getPlayer(args[1]);
						player.sendMessage(SaveString.Plutoncmdsee(tagetPlayer, Mysql_Pluton.getPluton(tagetPlayer.getUniqueId().toString())));
					}
				}
				
				
			}else {player.sendMessage(SaveString.NoPlayer);}
			if(player.hasPermission(SaveString.adminpermission)||player.hasPermission(SaveString.Plutonreset)) {
				if(args[0].equalsIgnoreCase("reset")) {
					if(Bukkit.getServer().getPlayer(args[1])!= null) {
						Player tagetPlayer = Bukkit.getPlayer(args[1]);
						Mysql_Pluton.setPluton(tagetPlayer.getUniqueId().toString(), 0);
						player.sendMessage(SaveString.Plutoncmdreset(tagetPlayer));
					}
					
				}
				
			}else {player.sendMessage(SaveString.NoPlayer);}
			
			
			
		}else if(args.length == 3) {
			if(player.hasPermission(SaveString.adminpermission)||player.hasPermission(SaveString.Plutonadd)) {
				//         0    1     2
				// Pluton Add Player Menge
			
				
			
					if(args[0].equalsIgnoreCase("Add")) {
						if(Bukkit.getServer().getPlayer(args[1])!= null) {
							Player tagetPlayer = Bukkit.getPlayer(args[1]);
							int menge = Integer.valueOf(args[2]);
							Mysql_Pluton.AddPluton(tagetPlayer.getUniqueId().toString(), menge);
							player.sendMessage(SaveString.Plutoncmdadd(tagetPlayer, menge));
							tagetPlayer.sendMessage(SaveString.Plutoncmdaddget(menge));
							
						}else {player.sendMessage(SaveString.NoPlayer);}

					}
			        }else {player.sendMessage(SaveString.noPermission);}
			if(player.hasPermission(SaveString.adminpermission)||player.hasPermission(SaveString.Plutonset)) {
					//Pluton Set Player Menge
					   if(args[0].equalsIgnoreCase("Set")) {
						if(Bukkit.getServer().getPlayer(args[1])!= null) {
							Player tagetPlayer = Bukkit.getPlayer(args[1]);
							int menge = Integer.valueOf(args[2]);
							Mysql_Pluton.setPluton(tagetPlayer.getUniqueId().toString(), menge);
							player.sendMessage(SaveString.Plutoncmdset(tagetPlayer, menge));
						}else {player.sendMessage(SaveString.NoPlayer);}
					}
					
				
			}else {player.sendMessage(SaveString.NoPlayer);}
				
				
			
			
		}
			
		
		
		
		
		
		return false;
	}
	
	
	
	
	

}
