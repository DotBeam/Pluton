package de.beam.Pluton.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import de.beam.Pluton.Api.FileManager;
import de.beam.Pluton.Main.Main;
import de.beam.Pluton.utilitys.SaveString;

public class Mysql {
	
	 public static int pingTimer = 1200;
	  public static BukkitTask pingTask;
	  public static Connection con;
	  private static String host = FileManager.getString("Mysql", "Mysql.Host");
	  private static String port = FileManager.getString("Mysql", "Mysql.Port");
	  private static String database = FileManager.getString("Mysql", "Mysql.Database");
	  private static String user = FileManager.getString("Mysql", "Mysql.User");
	  private static String password = FileManager.getString("Mysql", "Mysql.Pass");
	  
	  public static boolean connectMySQL()
	  {
	    boolean connected = false;
	    try
	    {
	      con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
	      connected = true;
	    }
	    catch (SQLException e)
	    {
	      Bukkit.getConsoleSender().sendMessage(SaveString.pr + "§4Ein Fehler ist beim Verbindungsaufbau zur MySQL-Datenbank aufgetreten.");
	      Bukkit.getConsoleSender().sendMessage(SaveString.pr + e.getMessage());
	    }
	    return connected;
	  }
	  
	  public static boolean isConnected()
	  {
	    boolean connected = false;
	    if (con != null) {
	      connected = true;
	    }
	    return connected;
	  }
	  
	  public static void pingMySQLServer()
	  {
	    pingTask = Bukkit.getScheduler().runTaskTimerAsynchronously(Main.main, new Runnable()
	    {
	      public void run()
	      {
	        try
	        {
	          if (Mysql.isConnected())
	          {
	            Statement s = Mysql.con.createStatement();
	            
	            s.executeQuery("/* ping */ SELECT 1");
	            s.close();
	            Bukkit.getConsoleSender().sendMessage(SaveString.pr + "§aDer MySQL-Server wurde erfolgreich angepingt");
	          }
	          else
	          {
	        	  Mysql.connectMySQL();
	          }
	        }
	        catch (SQLException e)
	        {
	          Bukkit.getConsoleSender().sendMessage(SaveString.pr + "§4Der MySQL-Server konnte nicht angepingt werden.");
	        }
	      }
	    }, 20L, 20 * pingTimer);
	  }
	  
	  public static void disconect()
	  {
	    if (isConnected()) {
	      try
	      {
	        con.close();
	        Bukkit.getConsoleSender().sendMessage(SaveString.pr + "§7MySQL §aerfolgreich §7Geschlossen!");
	      }
	      catch (SQLException e)
	      {
	        e.printStackTrace();
	      }
	    }
	  }

}
