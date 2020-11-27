package fr.awazek.chatoption;

import fr.awazek.chatoption.command.ChatCommand;
import fr.awazek.chatoption.event.ChatEvent;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
  public void onEnable() {
    saveDefaultConfig();
    getServer().getPluginManager().registerEvents((Listener)new ChatEvent(this), (Plugin)this);
    getCommand("chatoption").setExecutor((CommandExecutor)new ChatCommand(this));
  }
}
