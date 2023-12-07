package com.boggy.ispawners.inventory.listeners;

import com.boggy.ispawners.inventory.ISpInventoryHolder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListeners implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onClick(InventoryClickEvent event){
        if(!(event.getInventory().getHolder() instanceof ISpInventoryHolder ISpInventoryHolder)) return;
        ISpInventoryHolder.onClick(event);
    }
}
