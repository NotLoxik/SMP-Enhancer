package me.notloxik.smpenhancer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TpaManager {
    private final Map<UUID, TpaRequest> requests = new HashMap<>();

    public void sendRequest(Player from, Player to) {
        if (from.getUniqueId().equals(to.getUniqueId())) {
            from.sendMessage("§8[§cSystem§8] §7You can't send a teleport requests to yourself!");
            return;
        }

        requests.put(to.getUniqueId(), new TpaRequest(from, to));
        from.sendMessage("§8[§cSystem§8] §7You have sent a teleport request to §f" + to.getName() + "§7." );
        to.sendMessage("§8[§cSystem§8] §f " + from.getName() + "§7 wishes to teleport to you. Type §f/tpaccept §7to accept it.");
        to.sendMessage("§8[§cSystem§8] §7This request will automatically deny after §f60 seconds§7.");
    }

    public void acceptRequest(Player player) {
        final TpaRequest request = requests.get(player.getUniqueId());

        if (request == null) {
            player.sendMessage("§8[§cSystem§8] §7You don't have any tpa requests! :(");
            return;
        }

        final Player teleportTo = request.getFrom();
        teleportTo.teleport(player);

        requests.remove(player.getUniqueId());
    }
}