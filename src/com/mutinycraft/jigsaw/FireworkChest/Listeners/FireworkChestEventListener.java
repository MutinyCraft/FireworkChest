package com.mutinycraft.jigsaw.FireworkChest.Listeners;

import com.mutinycraft.jigsaw.FireworkChest.FireworkChest;
import com.mutinycraft.jigsaw.FireworkChest.Util.FireworkBuilder;
import com.mutinycraft.jigsaw.FireworkChest.Util.FireworkEffectPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

/**
 * User: Jigsaw
 * Date: 8/24/13
 * Time: 10:04 PM
 */

public class FireworkChestEventListener implements Listener{

    private FireworkEffectPlayer fplayer;
    private FireworkChest plugin;

    public FireworkChestEventListener(FireworkChest p){
        fplayer = new FireworkEffectPlayer();
        plugin = p;
    }

    @EventHandler(priority = EventPriority.LOW)
    public void ChestOpen(InventoryOpenEvent event) {
        Player player = null;

        if (event.getPlayer() instanceof Player) {
            player = (Player) event.getPlayer();
        }

        if (player != null && proceed() && event.getInventory().getType() == InventoryType.CHEST) {
            Location location = player.getLocation();
            location.add(plugin.getfX(), plugin.getfY(), plugin.getfZ());
            try {
                fplayer.playFirework(event.getPlayer().getWorld(), location,
                        FireworkBuilder.getRandomEffect(plugin.getfColor(), plugin.getfType()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean proceed(){
        if(plugin.getfChance().equalsIgnoreCase("seldom")){
            if((1 + (int)(Math.random() * ((10 - 1) + 1))) == 5){
                return true;
            }
            else {
                return false;
            }
        }
        else if(plugin.getfChance().equalsIgnoreCase("balanced")){
            if((1 + (int)(Math.random() * ((4 - 1) + 1))) == 2){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }
}
