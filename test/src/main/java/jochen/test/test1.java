package jochen.test;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class test1 implements CommandExecutor {

    private Test test;

    public test1(Test test) {
        this.test = test;

        test.getCommand("spawn").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = new Location(player.getWorld(),204, 45,-181);
            player.teleport(location);
            player.sendMessage(ChatColor.GREEN +"you are on spawn!");
        }
        return false;
    }
}
