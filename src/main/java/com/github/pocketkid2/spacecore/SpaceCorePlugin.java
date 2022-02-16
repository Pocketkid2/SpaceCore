package com.github.pocketkid2.spacecore;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.pocketkid2.spacecore.commands.SpaceCoreCommand;
import com.github.pocketkid2.spacecore.generation.SpaceChunkGenerator;

public class SpaceCorePlugin extends JavaPlugin {

	private static final ChatColor prefixColor = ChatColor.GRAY;

	/*
	 * A list of all the registered world generators
	 */
	private List<Class<? extends SpaceChunkGenerator>> installedWorldTypes;

	public static SpaceCorePlugin getInstance() {
		return (SpaceCorePlugin) Bukkit.getPluginManager().getPlugin("SpaceCore");
	}

	@Override
	public void onEnable() {
		installedWorldTypes = new ArrayList<>();
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

	/**
	 * Attempts to match the given string with a currently registered chunk
	 * generator.
	 *
	 * @param name The name of the chunk generator class
	 * @return The chunk generator class, if it exists (this is not an instance of
	 *         the class, but rather a Class object)
	 */
	public Class<? extends SpaceChunkGenerator> getGenerator(String name) {
		for (Class<? extends SpaceChunkGenerator> generator : installedWorldTypes) {
			if (generator.getClass().getSimpleName().equalsIgnoreCase(name))
				return generator;
		}
		return null;
	}

	/**
	 * Attempts to register the given generator class
	 *
	 * @param generator A world generator class that extends SpaceChunkGenerator
	 *                  given in the API
	 * @return true if successful, false if the plugin is not currently loaded
	 *         (might happen if, say, registration was attempted before the core
	 *         plugin was enabled)
	 */
	public static boolean registerGenerator(Class<? extends SpaceChunkGenerator> generator) {
		SpaceCorePlugin plugin = (SpaceCorePlugin) Bukkit.getPluginManager().getPlugin("spacecore");
		if (plugin == null)
			return false;
		plugin.installedWorldTypes.add(generator);
		return true;
	}
}
