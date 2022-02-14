package com.github.pocketkid2.spacecore.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.github.pocketkid2.spacecore.SpaceCorePlugin;

public class SpaceCoreCommand implements CommandExecutor {

	public abstract class SpaceCoreSubCommand {
		public abstract List<String> names();

		public abstract String usage();

		public abstract boolean isAdminCommand();

		public abstract boolean mustBePlayer();

		public abstract int maxArgs();

		public abstract int minArgs();
	}

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
