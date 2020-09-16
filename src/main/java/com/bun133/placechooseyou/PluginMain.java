package com.bun133.placechooseyou;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;

public class PluginMain extends JavaPlugin {
    public PlaceChooser chooser;
    public setBlockCommand setBlock;
    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            this.chooser=new PlaceChooser(this);
        } catch (FileNotFoundException e) {
            Bukkit.getLogger().warning(e.toString());
        }
        getCommand("game").setExecutor(new PlaceCommand(chooser));
        getCommand("s").setExecutor(new StatusCommand(chooser));
        getCommand("skip").setExecutor(new SkipCommand(chooser));
        this.setBlock = new setBlockCommand(chooser);
        getCommand("setSafe").setExecutor(setBlock);
        getCommand("setTime").setExecutor(new setTimeCommand(chooser));
        Bukkit.getServer().getPluginManager().registerEvents(setBlock,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
