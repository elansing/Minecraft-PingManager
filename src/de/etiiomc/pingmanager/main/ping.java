package de.etiiomc.pingmanager.main;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.command.ConsoleCommandSender;


public class ping implements CommandExecutor {
	
	  FileConfiguration cfg;
	  
	  public ping(FileConfiguration config)
	  {
	    this.cfg = config;
	  }
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ping")) {
			if((!(sender instanceof Player)) && (args.length == 0)) {
				System.out.println(this.cfg.getString("PingManager.prefix").replace("&", "§") + this.cfg.getString("PingManager.runbyplayer").replace("&", "§"));
			} else if(sender instanceof ConsoleCommandSender){
				Player player = Bukkit.getPlayer(args[0]);
				if (player != null) {
					System.out.println(this.cfg.getString("PingManager.prefix").replace("&", "§") + this.cfg.getString("PingManager.others.first").replace("&", "§") + player.getName() + this.cfg.getString("PingManager.others.second").replace("&", "§") +getPing(player) + this.cfg.getString("PingManager.ms").replace("&", "§"));
				} else {
					System.out.println(this.cfg.getString("PingManager.prefix").replace("&", "§") + this.cfg.getString("Pingmanager.notonline").replace("&", "§"));
				}
				
			} else {
				
				Player p = (Player)sender;
				if(!p.hasPermission("etiiomc.ping.use")){
					p.sendMessage(this.cfg.getString("PingManager.prefix").replace("&", "§") + this.cfg.getString("Pingmanager.nopermissions").replace("&", "§"));			
				} else if (args.length == 0) {
					p.sendMessage(this.cfg.getString("PingManager.prefix").replace("&", "§") + this.cfg.getString("PingManager.own").replace("&", "§") +getPing(p) + this.cfg.getString("PingManager.ms").replace("&", "§"));	
				} else {
					Player player = Bukkit.getPlayer(args[0]);
					if (player != null) {
						p.sendMessage(this.cfg.getString("PingManager.prefix").replace("&", "§") + this.cfg.getString("PingManager.others.first").replace("&", "§") + player.getName() + this.cfg.getString("PingManager.others.second").replace("&", "§") +getPing(p) + this.cfg.getString("PingManager.ms").replace("&", "§"));
					} else {
						p.sendMessage(this.cfg.getString("PingManager.prefix") + this.cfg.getString("Pingmanager.notonline"));
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("pingmanager")) {
			Player p = (Player)sender;
			p.sendMessage(this.cfg.getString("PingManager.prefix").replace("&", "§") + "§6PingManager Verision: v 1.3.0 §e| §cby etiiomc");
		}	
	return true;
	}
	public int getPing(Player p) {
		CraftPlayer pingc = (CraftPlayer) p;
		EntityPlayer pinge = pingc.getHandle();
		return pinge.ping;
	}
}
