package com.github.pocketkid2.spacecore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.pocketkid2.spacecore.commands.SpaceCoreCommand;

public class SpaceCorePlugin extends JavaPlugin {

	private static final ChatColor prefixColor = ChatColor.GRAY;

	public static SpaceCorePlugin getInstance() {
		return (SpaceCorePlugin) Bukkit.getPluginManager().getPlugin("SpaceCore");
	}

	@Override
	public void onEnable() {
		saveDefaultConfig();
		getCommand("spacecore").setExecutor(new SpaceCoreCommand(this));
		getLogger().info("Enabled!");
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabled!");
	}

	public String addPrefix(String message) {
		return String.format(ChatColor.AQUA + "[" + prefixColor + "%s" + ChatColor.AQUA + "] %s", getDescription().getName(), message);
	}
}
