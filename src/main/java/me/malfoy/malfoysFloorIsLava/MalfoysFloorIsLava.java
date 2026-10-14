package me.malfoy.malfoysFloorIsLava;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import me.malfoy.malfoysFloorIsLava.commands.LavaCommand;
import me.malfoy.malfoysFloorIsLava.listeners.FloorIsLavaListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MalfoysFloorIsLava extends JavaPlugin {
    private static MalfoysFloorIsLava instance;
    public boolean enabled = false;
    public String type = "tnt"; // should be tnt, lava or sand
    @Override
    public void onEnable() {
        getLogger().info("MalfoysFloorIsLava is loaded.");
        instance = this;
        getServer().getPluginManager().registerEvents(new FloorIsLavaListener(), this);
        getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            event.registrar().register(LavaCommand.create());
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static MalfoysFloorIsLava getInstance() {
        return instance;
    }
}
