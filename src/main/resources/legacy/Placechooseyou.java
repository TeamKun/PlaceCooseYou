package com.bun133.placechooseyou.legacy;

import org.bukkit.plugin.java.JavaPlugin;

public final class Placechooseyou extends JavaPlugin {
    public KotlinMain main;
    @Override
    public void onEnable() {
        // Plugin startup logic
        main = new KotlinMain(this);
        main.enable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        main.disable();
    }
}
