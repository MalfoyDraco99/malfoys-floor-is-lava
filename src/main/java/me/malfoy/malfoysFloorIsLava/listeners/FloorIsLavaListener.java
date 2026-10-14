package me.malfoy.malfoysFloorIsLava.listeners;

import io.papermc.paper.event.entity.EntityMoveEvent;
import me.malfoy.malfoysFloorIsLava.MalfoysFloorIsLava;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockType;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;
import java.util.Objects;

public class FloorIsLavaListener implements Listener {
    @EventHandler
    public void playerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if (MalfoysFloorIsLava.getInstance().enabled){
            // tnt check
            if (Objects.equals(MalfoysFloorIsLava.getInstance().type, "tnt")){
                Location location = player.getLocation().add(0,4,0);
                player.getWorld().spawnEntity(location, EntityType.TNT);
            }
            // lava check
            else if (Objects.equals(MalfoysFloorIsLava.getInstance().type, "lava")) {
                Location location = player.getLocation().add(0,15,0);
                Block block = player.getWorld().getBlockAt(location);
                block.setType(Material.LAVA);
            }
            else if (Objects.equals(MalfoysFloorIsLava.getInstance().type, "sand")) {
                Location location = player.getLocation().add(0,30,0);
                player.getWorld().spawnFallingBlock(location, Material.SAND.createBlockData());
            }
            else {
                MalfoysFloorIsLava.getInstance().getLogger().warning(("Unknown type "+ MalfoysFloorIsLava.getInstance().type));
                // this error should never happen because /lava type isnt a arg but whatever im adding it anyway cuz i realized this halfway thru
            }
        }
    }
}
