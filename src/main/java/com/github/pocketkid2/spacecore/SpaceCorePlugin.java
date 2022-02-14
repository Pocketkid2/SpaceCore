package com.github.pocketkid2.spacecore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.pocketkid2.spacecore.commands.SpaceCoreCommand;

public class SpaceCorePlugin extends JavaPlugin {

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
}
