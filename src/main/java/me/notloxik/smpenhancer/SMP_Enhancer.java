package me.notloxik.smpenhancer;

import me.notloxik.smpenhancer.commands.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class SMP_Enhancer extends JavaPlugin {

    private static SMP_Enhancer instance;
    private TpaManager tpaManager;

    @Override
    public void onLoad() {
        this.tpaManager = new TpaManager();
    }

    @Override
    public void onEnable() {

        getCommand("sit").setExecutor(new SitCommand());
        getCommand("tpa").setExecutor(new TpaCommand(tpaManager));
        getCommand("tpaccept").setExecutor(new TpacceptCommand(tpaManager));
    }

    public static SMP_Enhancer getInstance() {
        return instance;
    }



}
