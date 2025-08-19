package src;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SetNickPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("SetNickPlugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SetNickPlugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("setnick")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be used by players.");
                return true;
            }
            Player player = (Player) sender;
            if (args.length < 1) {
                player.sendMessage(ChatColor.RED + "Usage: /setnick <nickname>");
                return true;
            }
            StringBuilder nickBuilder = new StringBuilder();
            for (String arg : args) {
                nickBuilder.append(arg).append(" ");
            }
            String nickname = ChatColor.translateAlternateColorCodes('&', nickBuilder.toString().trim());
            player.setDisplayName(nickname);
            player.setPlayerListName(nickname);
            player.sendMessage(ChatColor.GREEN + "Your nickname has been set to " + nickname);
            return true;
        }
        return false;
    }
}
