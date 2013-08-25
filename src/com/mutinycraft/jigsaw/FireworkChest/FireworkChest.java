package com.mutinycraft.jigsaw.FireworkChest;

import com.mutinycraft.jigsaw.FireworkChest.Listeners.FireworkChestEventListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

/**
 * User: Jigsaw
 * Date: 8/24/13
 * Time: 8:10 PM
 */

public class FireworkChest extends JavaPlugin {

    private Logger log;
    private File configFile;
    private FileConfiguration config;

    private String fColor;
    private String fType;
    private String fChance;
    private int fX;
    private int fY;
    private int fZ;

    public void onEnable() {
        log = getLogger();
        config = new YamlConfiguration();

        try {
            configFile = new File(getDataFolder(), "config.yml");
            firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadYamls();
        setConfigOptions();

        getServer().getPluginManager().registerEvents(new FireworkChestEventListener(this), this);
    }

    private void setConfigOptions() {
        fColor = config.getString("Firework-Color", "red");
        fType = config.getString("Firework-Type", "ball");
        fChance = config.getString("Chance-To-Explode", "balanced");
        fX = config.getInt("Location-X-Value", 0);
        fY = config.getInt("Location-Y-Value", 10);
        fZ = config.getInt("Location-Z-Value", 0);
    }

    /**
     * Attempts to create the config.yml and lockedWorlds.yml if they do not already exist.
     *
     * @throws Exception
     */
    private void firstRun() throws Exception {
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            copy(getResource("config.yml"), configFile);
        }
    }

    /**
     * Copy data in memory to file.
     *
     * @param in
     * @param file
     */
    private void copy(InputStream in, File file) {
        try {
            OutputStream fout = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                fout.write(buf, 0, len);
            }
            fout.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Load yamls into memory.
     */
    private void loadYamls() {
        try {
            config.load(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Reloads config.yml which allows changes to be made while server is running.
     */
    @Override
    public void reloadConfig() {
        loadYamls();
        setConfigOptions();
    }

    public String getfColor() {
        return fColor;
    }

    public String getfType() {
        return fType;
    }

    public String getfChance() {
        return fChance;
    }

    public int getfX() {
        return fX;
    }

    public int getfY() {
        return fY;
    }

    public int getfZ() {
        return fZ;
    }
}
