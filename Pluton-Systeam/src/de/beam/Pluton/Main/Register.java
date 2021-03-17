package de.beam.Pluton.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import de.beam.Pluton.Events.CreateNewPlutondb;
import de.beam.Pluton.Mysql.Mysql_create;
import de.beam.Pluton.cmd.Cmd_Pluton;
import de.beam.Pluton.utilitys.Config;
import de.beam.Pluton.utilitys.SaveString;


public class Register {

	
	
	private static final PluginDescriptionFile pdf = Main.main.getDescription();
    private static final ConsoleCommandSender send = Bukkit.getConsoleSender();
    private static final String pr = SaveString.pr;
	
	
    public static void Starter() {
    	final String Autor = pdf.getAuthors().toString().replace("[", " ").replace("]", " ");
    	
    	Config.CreateCfgs();    	
    	
    	send.sendMessage(pr+"§7┌──────────────────────────────────────────►");
		send.sendMessage(pr+"§7│");
		send.sendMessage(pr+"§7├►  §aName:    §5 "+pdf.getName());
		send.sendMessage(pr+"§7├►  §aAuthor: §5 "+Autor);
		send.sendMessage(pr+"§7├►  §aVersion: §5 "+pdf.getVersion());
		send.sendMessage(pr+"§7│");
		send.sendMessage(pr+"§7├──────────────────────────────────────────►");
		send.sendMessage(pr+"§7│");
		send.sendMessage(pr+"§7├►    Commands Werden Geladen");
		send.sendMessage(pr+"§7│");
		cmds();
		send.sendMessage(pr+"§7├──────────────────────────────────────────►");
		send.sendMessage(pr+"§7│");
		send.sendMessage(pr+"§7├►    Events Werden Geladen");
		send.sendMessage(pr+"§7│");
        Events();
        send.sendMessage(pr+"§7├──────────────────────────────────────────►");
		send.sendMessage(pr+"§7│");
		send.sendMessage(pr+"§7├►    Mysql Connecton Wird gestart");
		send.sendMessage(pr+"§7│");
		Mysql();
        send.sendMessage(pr+"§7└──────────────────────────────────────────►");
    }
    
    
    private static void cmds() {
    	loadCommand("Pluton", new Cmd_Pluton());
    	
    }
    private static void Events() {
    	loadEvent(new CreateNewPlutondb());
    }
    private static void Mysql() {
    	de.beam.Pluton.Mysql.Mysql.connectMySQL();
    	if(de.beam.Pluton.Mysql.Mysql.isConnected()) {
    		  send.sendMessage(pr+"§7├► §a Verbindung zu Datenbank Wurde hergestllt");
              send.sendMessage(pr+"§7│");
    	}else {
    		 send.sendMessage(pr+"§7├► §c Verbindung zu Datenbank konnte nicht hergestllt werden");
             send.sendMessage(pr+"§7│");
    	}
        Mysql_create.createbase();
    	
    }
    private static void loadCommand(String command, CommandExecutor commandExecutor) {
        try{
        	Main.main.getCommand(command).setExecutor(commandExecutor);
            send.sendMessage(pr+"§7├► §aDie Classe "+commandExecutor.getClass().getSimpleName()+" wurde geladen");
            send.sendMessage(pr+"§7│");
            return;
        }catch (Exception e) {
        	send.sendMessage(pr+"§7├► §cDie Classe "+commandExecutor.getClass().getSimpleName()+" konnte nicht geladen werden!");
            e.printStackTrace();
            send.sendMessage(pr+"§7│");
            return;
        }
        
    }
	private static void loadEvent(Listener listener) {
        try{
            PluginManager pluginManager = Bukkit.getPluginManager();
            pluginManager.registerEvents(listener,  Main.main);
            send.sendMessage(pr+"§7├► §aDie Classe "+listener.getClass().getSimpleName()+" wurde geladen");
            send.sendMessage(pr+"§7│");
        }catch (Exception e) {
        	send.sendMessage(pr+"§7├► §cDie Classe "+listener.getClass().getSimpleName()+" konnte nicht geladen werden!");
        	send.sendMessage(pr+"§7│");
        }
       
    }
}
