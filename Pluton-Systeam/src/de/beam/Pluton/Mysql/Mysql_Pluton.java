package de.beam.Pluton.Mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;

public class Mysql_Pluton {
	
	
	public static int getPluton(String UUID) {
		
		    try
		    {
		      Statement s = Mysql.con.createStatement();
		      ResultSet rs = s.executeQuery("SELECT Pluton FROM Pluton WHERE UUID= '" + UUID + "'");
		      if (rs.next()) {
		        return rs.getInt("Pluton");
		      }
		      s.close();
		    }
		    catch (SQLException e)
		    {
		      Bukkit.getConsoleSender().sendMessage("§c" + e);
		    }
		    return 0;
		  }
	
	public static void AddPluton(String UUID,int num) {
		
		int z = getPluton(UUID)+num;
		
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Pluton SET Pluton = " + z + " WHERE UUID= '" +UUID + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static void removePluton(String UUID,int num) {
		
		int z = getPluton(UUID)-num;
		
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Pluton SET Pluton = " + z + " WHERE UUID= '" +UUID + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static void resetPluton(String UUID) {
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Pluton SET Pluton = 0 WHERE UUID= '" +UUID + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static void setPluton(String UUID,int num) {
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Pluton SET Pluton = "+num+" WHERE UUID= '" +UUID+ "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static boolean hasPluton(String UUID,int num) {
		
		int hasCoins = getPluton(UUID);
		
		if(hasCoins >= num) {
			return true;
		}
		return false;
	}
	public static HashMap<String,Integer> top10() {
		
		
		 Map<String,Integer> thisHashMap = new HashMap<>();
	      try {
	    	Statement s = Mysql.con.createStatement();
	    	 ResultSet rs = s.executeQuery("SELECT Username,Pluton FROM Pluton ORDER BY Pluton DESC LIMIT 10");
	    	 while (rs.next()) {
	    		
	    		 thisHashMap.put(rs.getString("Username"), rs.getInt("Pluton"));
	    		 
	    		 
	    	 }
	    	 return (HashMap<String, Integer>) thisHashMap;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return null;
	}

}
