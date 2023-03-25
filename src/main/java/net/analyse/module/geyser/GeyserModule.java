package net.analyse.module.geyser;

import net.analyse.sdk.module.PlatformModule;
import net.analyse.sdk.obj.AnalysePlayer;
import net.analyse.sdk.platform.PlayerType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.geysermc.api.Geyser;

public class GeyserModule extends PlatformModule implements Listener {
    @Override
    public String getName() {
        return "Geyser";
    }

    @Override
    public String getRequiredPlugin() {
        return "Geyser-Spigot";
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {

    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event) {
        Player eventPlayer = event.getPlayer();
        AnalysePlayer player = getPlatform().getPlayer(eventPlayer.getUniqueId());
        if (!Geyser.api().isBedrockPlayer(eventPlayer.getUniqueId())) return;

        player.setType(PlayerType.BEDROCK);
    }
}

