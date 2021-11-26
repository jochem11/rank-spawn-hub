package jochen.test;

import jochen.test.ranks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Test extends JavaPlugin implements Listener {

    HashMap<Player, ranks> rank = new HashMap<Player, ranks>();
    HashMap<ranks, String> prefix = new HashMap<ranks, String>();




    private static Test instance;

    @Override
    public void onEnable() {
        Test.instance = this;
        new test1(this);
        new hub(this);
        new Command();

        Test.getInstance().getServer().getPluginManager().registerEvents(this, this); // Register the events
        prefix.put(ranks.HENK, ChatColor.LIGHT_PURPLE + "HENK"); // Set the Ultra rank's prefix
        prefix.put(ranks.DAVOR, ChatColor.AQUA + "DAVOR"); // Set the Hero rank's prefix
        reloadConfig();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Test getInstance() {
        return instance;
    }

    public ranks getRank(Player p) {
        ranks r = rank.get(p);
        return r;
    }

    public void setRank(Player p, ranks r) {
        rank.put(p, r);
        p.setDisplayName(prefix.get(r) + p.getName());
        p.setPlayerListName(prefix.get(r) + p.getName());
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (this.getConfig().getString(e.getPlayer().getName()) != null) {
            e.getPlayer().setDisplayName(getConfig().getString(e.getPlayer().getName()) + ChatColor.RESET);
        }

    }

}
