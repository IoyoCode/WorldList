package com.seailz.worldlist.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class worldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("You must be a player to run this command!");
            return true;
        }
        Player p = (Player) sender;
        Inventory gui = Bukkit.createInventory(p, 45, "Worlds");

        ItemStack noItem = new ItemStack(Material.WHITE_STAINED_GLASS);
        ItemMeta noItemMeta = noItem.getItemMeta();
        noItemMeta.setDisplayName(" ");
        noItem.setItemMeta(noItemMeta);
        gui.setItem(0, noItem);
        gui.setItem(1, noItem);
        gui.setItem(2, noItem);
        gui.setItem(3, noItem);

        int guiNumber = 10;
        for (World w : Bukkit.getWorlds()) {
            guiNumber++;
            ItemStack world = new ItemStack(Material.PAPER);
            ItemMeta worldMeta = world.getItemMeta();
            worldMeta.setDisplayName(ChatColor.BOLD + w.getName());
            world.setItemMeta(worldMeta);
            gui.setItem(guiNumber, world);
        }
        p.openInventory(gui);


        return true;
    }
}
