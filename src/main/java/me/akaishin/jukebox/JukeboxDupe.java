package me.akaishin.jukebox;

/*Imports others */
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/*Commands Inport */
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public final class JukeboxDupe extends JavaPlugin { // PLUGIN CREADO POR XG2025 + AnarchyGooD // PLUGIN BY AnarchyGooD // NEW CODE


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JukeboxDupeListener(), this);
        getCommand("jukeboxdupereload").setExecutor(new ReloadCommand());
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private final class JukeboxDupeListener implements Listener {

        @EventHandler
        public void onRightClick(PlayerInteractEvent event) {
            Player p = event.getPlayer();
            Block block = event.getClickedBlock();
            ItemStack itemStack = event.getItem();
            if(event.getClickedBlock() == null) return;
                if (block.getType().equals(Material.JUKEBOX) && event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInOffHand().getType().isRecord()) {
                    if (!(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR)) {
                            int rng = (int)Math.round(Math.random() * 100);
                                if (rng < getConfig().getInt("probability-percentage")) {
                                    block.getWorld().dropItemNaturally(block.getLocation().add(0, 1, 0), p.getInventory().getItemInMainHand());
                                }
                        }
                    }
                }
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private final class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            reloadConfig();
            return true;
        }
        return false;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}





