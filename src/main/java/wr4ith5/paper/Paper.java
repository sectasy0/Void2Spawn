package wr4ith5.paper;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

class EventListener implements Listener{
    @EventHandler
    public void onPlayerDamageByVoid(EntityDamageEvent event){
        if(event.getCause().equals(EntityDamageEvent.DamageCause.VOID) && event.getEntity() instanceof Player){
            event.setCancelled(true);

            Player player = (Player) event.getEntity();
            Location spawnLocation = Objects.requireNonNull(player.getServer().getWorld("world")).getSpawnLocation();

            player.teleport(spawnLocation);
        }
    }
}

public final class Paper extends JavaPlugin {
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }
}
