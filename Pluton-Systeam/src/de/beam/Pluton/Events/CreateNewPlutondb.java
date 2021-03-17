package de.beam.Pluton.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.beam.Pluton.Mysql.Mysql_create;
import de.beam.Pluton.Mysql.Mysql_hasProfil;

public class CreateNewPlutondb implements Listener {

	@EventHandler
	public void create(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!Mysql_hasProfil.hasPlayerProfiel(p)) {
			Mysql_create.createuser(p);
		}
		
		
		
	}
	
	
}
