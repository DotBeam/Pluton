package de.beam.Pluton.Mysql;

import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;



public class Mysql_create {
	
public static void createbase() {
		
		try {
			 Statement s = Mysql.con.createStatement();
		      
		      s.executeUpdate("CREATE TABLE IF NOT EXISTS Pluton (UUID VARCHAR(100),Username VARCHAR(32),Pluton INT(20))");

		    
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void createuser(Player p) {
	
	if(Mysql.isConnected()) {
		
		
		try {
			Statement s = Mysql.con.createStatement();
	        
	        s.executeUpdate("INSERT INTO Pluton (UUID, Username, Pluton) VALUES ('" + p.getUniqueId() +"','"+p.getName()+"','0')");
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

}
