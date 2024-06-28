package eu.nexucode.xevix.xscoreboard.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtils {
   private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

   public static String color(String message) {
      if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
         message = PlaceholderAPI.setPlaceholders(null, message);
      }
      Matcher matcher = pattern.matcher(message);

      while (matcher.find()) {
         String color = message.substring(matcher.start(), matcher.end());
         message = message.replace(color, ChatColor.of(color) + "");
         matcher = pattern.matcher(message);

      }
      return ChatColor.translateAlternateColorCodes('&', message).replaceAll("&", "");
   }
}
