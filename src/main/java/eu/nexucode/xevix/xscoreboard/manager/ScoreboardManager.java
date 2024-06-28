package eu.nexucode.xevix.xscoreboard.manager;

import eu.nexucode.xevix.xscoreboard.Main;
import eu.nexucode.xevix.xscoreboard.utils.ColorUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardManager {
    public void create(Player player){
        org.bukkit.scoreboard.ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("customBoard", "dummy", ColorUtils.color(Main.getCfg.getString("scoreboard.title")));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score line1 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&7· &fᴘᴏᴛʀᴢᴇʙᴜᴊᴇsᴢ ᴘᴏᴍᴏᴄʏ?"));
        line1.setScore(10);
        for (String scoreString : Main.getCfg.getConfigurationSection("scoreboard.scores").getKeys(false)){
            Score score = objective.getScore(ColorUtils.color(Main.getCfg.getString("scoreboard.scores." + scoreString)));
            score.setScore(Integer.parseInt(scoreString));
        }
        player.setScoreboard(board);
    }
}
