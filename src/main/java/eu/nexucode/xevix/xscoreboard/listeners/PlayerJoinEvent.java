package eu.nexucode.xevix.xscoreboard.listeners;

import eu.nexucode.xevix.xscoreboard.manager.ScoreboardManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    @EventHandler
    public void playerjoinEvent(org.bukkit.event.player.PlayerJoinEvent event){
        ScoreboardManager scManager = new ScoreboardManager();
        scManager.create(event.getPlayer());
    }
}
