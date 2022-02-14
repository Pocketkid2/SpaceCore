package com.github.pocketkid2.spacecore;

import org.bukkit.plugin.java.JavaPlugin;

public class SpaceCorePlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		saveDefaultConfig();
		getLogger().info("Enabled!");
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabled!");
	}
}
