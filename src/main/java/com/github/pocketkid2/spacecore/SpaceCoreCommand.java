package com.github.pocketkid2.spacecore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SpaceCoreCommand implements CommandExecutor {

	private SpaceCorePlugin plugin;

	public SpaceCoreCommand(SpaceCorePlugin p) {
		plugin = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

}
