package com.boggy.ispawners.inventory;

import com.boggy.ispawners.ISpawners;
import com.boggy.ispawners.spawner.SpawnersManager;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SpawnerInventory extends GUIHolder {
    private ISpawners plugin;
    private SpawnersManager spawnersManager;
    private InventoryManager inventoryManager;

    public SpawnerInventory(Player player, CreatureSpawner spawner, String title) {
        super(title, 27);

        this.plugin = ISpawners.getInstance();
        this.spawnersManager = this.plugin.getSpawnersManager();
        this.inventoryManager = this.plugin.getInventoryManager();

//        HashMap<Player, CreatureSpawner> openedSpawners = plugin.getSpawnerUITracker();
//        for (Player playerSpawnerOpen : openedSpawners.keySet()) {
//            if (openedSpawners.get(playerSpawnerOpen).equals(spawner)) {
//                if (playerSpawnerOpen.getOpenInventory().getTitle().contains("Spawner")) {
//                    return;
//                }
//            }
//        }
        if (!spawnersManager.exists(spawner)) {
            player.closeInventory();
            return;
        }
        inventoryManager.removeViewer(player);
        inventoryManager.addViewer(player, spawner);

        int stackSize = spawnersManager.getStackSize(spawner);
        String spawnerType = spawner.getSpawnedType().toString().toLowerCase();
        String spawnerText = (stackSize > 1) ? "Spawners" : "Spawner";
        String items = "0";

//        if (plugin.getDrops(spawner) != null) {
//           items = String.valueOf(plugin.getDrops(spawner).size());
//        }


//        ItemStack drops = new ItemStack(Material.CHEST);
//        ItemMeta dropsMeta = drops.getItemMeta();
//        dropsMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of("#ffaa00") + "" + ChatColor.BOLD + "SPAWNER STORAGE");
//        dropsMeta.setLore(List.of(net.md_5.bungee.api.ChatColor.of("#ffaa00") + items + ChatColor.WHITE + " Items"));
//        dropsMeta.setLocalizedName("spawnerUI");
//        drops.setItemMeta(dropsMeta);
//        inventory.setItem(11, drops);
//
//        ItemStack xp = new ItemStack(Material.EXPERIENCE_BOTTLE);
//        ItemMeta xpMeta = xp.getItemMeta();
//        xpMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of("#36ffa4") + "" + ChatColor.BOLD + "COLLECT XP");
//        xpMeta.setLore(List.of(net.md_5.bungee.api.ChatColor.of("#36ffa4") + String.valueOf(plugin.getXP(spawner)) + ChatColor.WHITE + " XP Points"));
//        xpMeta.setLocalizedName("spawnerUI");
//        xp.setItemMeta(xpMeta);
//        inventory.setItem(15, xp);
//
//        ItemStack middle;
//
//        Material head = Material.getMaterial(spawnerType.toUpperCase() + "_HEAD");
//
//        if (head != null) {
//            middle = new ItemStack(Material.valueOf(spawnerType.toUpperCase() + "_HEAD"));
//        } else {
//            middle = new ItemStack(Material.SPAWNER);
//        }
//
//        ItemMeta middleMeta = middle.getItemMeta();
//        middleMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of("#fc6aae") + "" + ChatColor.BOLD + stackSize + " " + spawnerType.toUpperCase() + " " + spawnerText.toUpperCase());
//        middleMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
//        middleMeta.setLocalizedName("spawnerUI");
//        ArrayList<String> lore = new ArrayList<>();
//        double fillPercent = SpawnerUtils.getFillPercent(plugin, spawner);
//        lore.add(net.md_5.bungee.api.ChatColor.of("#fc6aae") + String.valueOf(fillPercent) + "%" + ChatColor.WHITE + " filled");
//        middleMeta.setLore(lore);
//        middle.setItemMeta(middleMeta);
//        inventory.setItem(13, middle);

        player.openInventory(inventory);
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true);
//        ItemStack item = e.getCurrentItem();
//        Player player = (Player) e.getWhoClicked();
//        CreatureSpawner spawner = plugin.getSpawnerUITracker().get(player);
//
//        if (item == null || item.getType().equals(Material.AIR)) {
//            return;
//        }
//
//        if (item.getType().equals(Material.CHEST)) {
//            player.closeInventory();
//            new DropsUI(player, spawner, plugin, 1);
//        } else if (item.getType().equals(Material.EXPERIENCE_BOTTLE)) {
//            SpawnerUtils.handleXP(player, spawner, item, plugin);
//        } else if (item.getType().equals(Material.GOLD_INGOT)) {
//            SpawnerUtils.handleSell(player, spawner, true, plugin);
//            new DropsUI(player, spawner, plugin, 1);
//        } else if (item.getType().toString().contains("HEAD") || item.getType().equals(Material.SPAWNER)) {
//            SpawnerUtils.handleSell(player, spawner, true, plugin);
//            SpawnerUtils.handleXP(player, spawner, e.getInventory().getItem(15), plugin);
//            ItemMeta itemMeta = item.getItemMeta();
//            ArrayList<String> middleLore = new ArrayList<>();
//            middleLore.add(net.md_5.bungee.api.ChatColor.of("#fc6aae") + "0.0%" + ChatColor.WHITE + " filled");
//            itemMeta.setLore(middleLore);
//            item.setItemMeta(itemMeta);
//            ItemStack drops = e.getInventory().getItem(11);
//            ItemMeta dropsMeta = drops.getItemMeta();
//            dropsMeta.setLore(Arrays.asList(net.md_5.bungee.api.ChatColor.of("#ffaa00") + "0" + ChatColor.WHITE + " Items"));
//            drops.setItemMeta(dropsMeta);
//        }
    }

}
