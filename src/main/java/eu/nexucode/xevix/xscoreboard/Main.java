package eu.nexucode.xevix.xscoreboard;

import eu.nexucode.xevix.xscoreboard.commands.XscoreCmd;
import eu.nexucode.xevix.xscoreboard.listeners.PlayerJoinEvent;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {
public static YamlConfiguration getCfg;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        saveResource("config.yml", false);
        System.out.println(this.getDataFolder().getAbsolutePath());
        getCfg = new YamlConfiguration();
        try {
            getCfg.load(new File(this.getDataFolder().getAbsolutePath(), "config.yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        this.getServer().getPluginCommand("x-score").setExecutor(new XscoreCmd());

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
