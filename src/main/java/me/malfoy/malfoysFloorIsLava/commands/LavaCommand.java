package me.malfoy.malfoysFloorIsLava.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import me.malfoy.malfoysFloorIsLava.MalfoysFloorIsLava;
import me.malfoy.malfoysFloorIsLava.listeners.FloorIsLavaListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;

public class LavaCommand {
    public static LiteralCommandNode<CommandSourceStack> create(){
        return Commands.literal("lava")
                .then(Commands.literal("enable")
                        .executes(context -> {
                            var source = context.getSource();
                            if (!(source.getExecutor() instanceof Player player)){
                                source.getSender().sendMessage(Component.text("Only a player can run this command", NamedTextColor.RED));
                                return 0;
                            }
                            MalfoysFloorIsLava.getInstance().enabled = true;
                            player.sendMessage(Component.text("Floor is lava has been enabled. RUN!!", NamedTextColor.GREEN));
                            return 1;
                        }))
                .then(Commands.literal("disable")
                        .executes(context -> {
                            var source = context.getSource();
                            if (!(source.getExecutor() instanceof Player player)){
                                source.getSender().sendMessage(Component.text("Only a player can run this command", NamedTextColor.RED));
                                return 0;
                            }
                            MalfoysFloorIsLava.getInstance().enabled = false;
                            player.sendMessage(Component.text("Floor is lava has been disabled.", NamedTextColor.GREEN));
                            return 1;
                        }))
                .then(Commands.literal("type")
                        .then(Commands.literal("lava")
                                .executes(context -> {
                                    var source = context.getSource();
                                    if (!(source.getExecutor() instanceof Player player)){
                                        source.getSender().sendMessage(Component.text("Only a player can run this command", NamedTextColor.RED));
                                        return 0;
                                    }
                                    MalfoysFloorIsLava.getInstance().type = "lava";
                                    player.sendMessage(Component.text("Type has been set to lava", NamedTextColor.GREEN));
                                    return 1;
                                }))
                        .then(Commands.literal("tnt")
                                .executes(context -> {
                                    var source = context.getSource();
                                    if (!(source.getExecutor() instanceof Player player)){
                                        source.getSender().sendMessage(Component.text("Only a player can run this command", NamedTextColor.RED));
                                        return 0;
                                    }
                                    MalfoysFloorIsLava.getInstance().type = "tnt";
                                    player.sendMessage(Component.text("Type has been set to tnt", NamedTextColor.GREEN));
                                    return 1;
                                }))
                        .then(Commands.literal("sand")
                                .executes(context -> {
                                    var source = context.getSource();
                                    if (!(source.getExecutor() instanceof Player player)){
                                        source.getSender().sendMessage(Component.text("Only a player can run this command", NamedTextColor.RED));
                                        return 0;
                                    }
                                    MalfoysFloorIsLava.getInstance().type = "sand";
                                    player.sendMessage(Component.text("Type has been set to sand", NamedTextColor.GREEN));
                                    return 1;
                                })))
                .build();
    }
}
