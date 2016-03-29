package com.minecraftport.zombieRevenge;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    public static main plugin;
    public final zombieKillListener zkl = new zombieKillListener(this);


    double spawnChanceInt = getConfig().getInt("spawnChance");

    @Override
    public void onDisable(){

    }

    @Override
    public void onEnable(){
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(this.zkl, this);
        new zombieKillListener(this);

        PluginDescriptionFile config = this.getDescription();
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
