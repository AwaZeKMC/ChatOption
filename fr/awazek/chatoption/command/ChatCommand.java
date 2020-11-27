package fr.awazek.chatoption.command;

import fr.awazek.chatoption.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommand implements CommandExecutor {
  Main main;
  
  public ChatCommand(Main main) {
    this.main = main;
  }
  
  public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
    if (args.length == 2) {
      if (args[0].equalsIgnoreCase("enable")) {
        if (args[1].equalsIgnoreCase("on")) {
          this.main.getConfig().set("chat-enable", Boolean.valueOf(true));
          for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers())
            onlinePlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("chat-message.chat-enable"))); 
          this.main.saveConfig();
        } else if (args[1].equalsIgnoreCase("off")) {
          this.main.getConfig().set("chat-enable", Boolean.valueOf(false));
          for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers())
            onlinePlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("chat-message.chat-disable"))); 
          this.main.saveConfig();
        } else {
          sender.sendMessage(ChatColor.GRAY + "correct usage : /chatoption (enable) (on/off)");
        } 
      } else {
        sender.sendMessage(ChatColor.GRAY + "correct usage : /chatoption (enable) (on/off)");
      } 
    } else {
      sender.sendMessage(ChatColor.GRAY + "correct usage : /chatoption (enable) (on/off)");
    } 
    return false;
  }
}
