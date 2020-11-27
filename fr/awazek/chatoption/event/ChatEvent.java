package fr.awazek.chatoption.event;

import fr.awazek.chatoption.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatEvent implements Listener {
  Main main;
  
  public ChatEvent(Main main) {
    this.main = main;
  }
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent event) {
    if (!this.main.getConfig().getBoolean("chat-enable"))
      event.setCancelled(true); 
    if (event.getPlayer().hasPermission("chatoption.bypass"))
      event.setCancelled(false); 
  }


  @EventHandler
  public void onJoin(PlayerJoinEvent event){
    if (main.getConfig().getBoolean("join-message.enable")) {
      event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("join-message.message").replace("%players%", event.getPlayer().getName())));
    } else {
      event.setJoinMessage(null);
    }

  }
}
