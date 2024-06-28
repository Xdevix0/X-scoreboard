package eu.nexucode.xevix.xscoreboard.commands;

import eu.nexucode.xevix.xscoreboard.Main;
import eu.nexucode.xevix.xscoreboard.manager.ScoreboardManager;
import eu.nexucode.xevix.xscoreboard.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class XscoreCmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("x-score")){
            Player p = (Player) sender;
            if (args.length < 2){
                p.sendMessage(ColorUtils.color("&#FB0808P&#FB0A0Ao&#FB0C0Cp&#FB0E0Er&#FB1010a&#FB1111w&#FB1313n&#FC1515e &#FC1919u&#FC1B1Bz&#FC1D1Dy&#FC1F1Fc&#FC2020i&#FC2222e &#FC2626/&#FC2828x&#FC2A2A-&#FC2C2Cs&#FD2E2Ec&#FD3030o&#FD3131r&#FD3333e &#FD3737r&#FD3939e&#FD3B3Bl&#FD3D3Do&#FD3F3Fa&#FD4040d &#FE4444<&#FE4646s&#FE4848c&#FE4A4Ao&#FE4C4Cr&#FE4E4Ee&#FE5050b&#FE5151o&#FE5353a&#FE5555r&#FE5757d&#FE5959/&#FE5B5Bt&#FF5D5Da&#FF5F5Fb&#FF6060l&#FF6262i&#FF6464s&#FF6666t&#FF6868>"));
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")){
                if (p.hasPermission("x-score.scoreboard.reload")){
                if (args[1].equalsIgnoreCase("scoreboard")) {
                    try {
                        Main.getCfg.load(new File(Main.getPlugin(Main.class).getDataFolder().getAbsolutePath(), "config.yml"));
                        p.sendMessage(ColorUtils.color("&#FB0808U&#FB0B0Bd&#FB0E0Ea&#FB1111l&#FC1414o &#FC1B1Bs&#FC1E1Ei&#FC2121e &#FC2727p&#FC2A2Ar&#FD2D2Dz&#FD3030e&#FD3333l&#FD3636a&#FD3A3Ad&#FD3D3Do&#FD4040w&#FD4343a&#FE4646c &#FE4C4Cs&#FE4F4Fc&#FE5252o&#FE5555r&#FE5959e&#FE5C5Cb&#FF5F5Fo&#FF6262a&#FF6565r&#FF6868d"));
                        for (Player player : Bukkit.getOnlinePlayers()){
                            ScoreboardManager scoreboardManage = new ScoreboardManager();
                            scoreboardManage.create(player);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InvalidConfigurationException e) {
                        p.sendMessage(ColorUtils.color("&#FB0808C&#FB0D0Do&#FB1212n&#FC1717f&#FC1C1Ci&#FC2121g &#FC2B2Bp&#FD3030o&#FD3535s&#FD3B3Bi&#FD4040a&#FE4545d&#FE4A4Aa &#FE5454b&#FE5959l&#FF5E5Ee&#FF6363d&#FF6868y"));
                        throw new RuntimeException(e);
                    }
                }
                }
            }
        }
        return false;
    }
}
