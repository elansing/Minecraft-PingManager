package de.etiiomc.pingmanager.main;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
		public void onEnable() {
	    config();
	    System.out.println("§ePing Manager§f | Enabled!");
		this.getCommand("ping").setExecutor(new ping(getConfig()));
		this.getCommand("pingmanager").setExecutor(new ping(getConfig()));
	}
		  
		  public void config()
		  {
		    getConfig().options().header("PingManager v 1.3.0 by etiiomc");
			getConfig().addDefault("PingManager.prefix", "[§betiiomc.de Ping Bot§f] ");
			getConfig().addDefault("PingManager.nopermissions", "§aDu hast nicht die Rechte dazu!");
			getConfig().addDefault("PingManager.runbyplayer", "§aDu kannst deinen Ping nur als Spieler abrufen!");
			getConfig().addDefault("PingManager.notonline", "§aDieser Spieler ist leider nicht online!");
			getConfig().addDefault("PingManager.others.first", "§aDer Spieler ");
			getConfig().addDefault("PingManager.others.second", "§ahat einen Ping von ");
			getConfig().addDefault("PingManager.own", "§aDu hast einen Ping von ");
			getConfig().addDefault("PingManager.ms", "§ams.");
		    getConfig().options().copyDefaults(true);
		    saveConfig();
		  }
		
}