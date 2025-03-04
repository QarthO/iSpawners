package com.boggy.ispawners.inventory;

import com.boggy.ispawners.ISpConfig;
import com.boggy.ispawners.ISpawners;
import com.boggy.ispawners.spawner.SpawnersManager;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public abstract class ISpInventoryHolder implements InventoryHolder {

    protected Inventory inventory;
    protected ISpawners plugin;
    protected ISpViewersManager viewersManager;
    protected ISpConfig config;
    protected SpawnersManager spawnersManager;
    protected CreatureSpawner spawner;
    protected String title;

    public ISpInventoryHolder(int inventorySize, CreatureSpawner spawner, EntityType spawnerType, int stackSize){
        this.plugin = ISpawners.getInstance();
        this.config = this.plugin.getIspConfig();
        this.spawnersManager = this.plugin.getSpawnersManager();
        this.viewersManager = this.plugin.getViewersManager();

        this.spawner = spawner;

        this.title = (stackSize == 1 ? "" : (stackSize + " ")) + (spawnerType == null ? "Empty" : WordUtils.capitalizeFully(spawnerType.name())) + (stackSize > 1 ? " Spawners" : " Spawner");
        this.inventory = Bukkit.createInventory(this, inventorySize, this.title);
    }

    public ISpInventoryHolder(){
        this.plugin = ISpawners.getInstance();
        this.config = this.plugin.getIspConfig();
        this.spawnersManager = this.plugin.getSpawnersManager();
    }

    public void createInventory(int size, String title){
        this.inventory = Bukkit.createInventory(this, size, title);
    }

    @Override
    public @NotNull Inventory getInventory(){
        return inventory;
    }

    public abstract void onClick(InventoryClickEvent event);

}
