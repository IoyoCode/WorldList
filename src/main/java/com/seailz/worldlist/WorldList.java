package com.seailz.worldlist;

import com.seailz.worldlist.GUI.worldCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldList extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("worlds").setExecutor(new worldCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
