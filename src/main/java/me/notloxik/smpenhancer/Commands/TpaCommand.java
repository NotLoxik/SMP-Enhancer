package me.notloxik.smpenhancer.commands;

import me.notloxik.smpenhancer.TpaManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TpaCommand implements CommandExecutor {
    private final TpaManager tpaManager;

    public TpaCommand(TpaManager tpaManager) {
        this.tpaManager = tpaManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§8[§cSystem§8] §7Only players can execute this command!");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage("§8[§cSystem§8] §7Usage: §f/" + label + " <player>");
            return true;
        }

        final Player to = Bukkit.getPlayer(args[0]);

        if (to == null) {
            player.sendMessage("§8[§cSystem§8] §7This player is not online!");
            return true;
        }

        tpaManager.sendRequest(player, to);
        return true;
    }
}

