package com.github.pocketkid2.spacecore.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.pocketkid2.spacecore.SpaceCorePlugin;

import net.md_5.bungee.api.ChatColor;

public class SpaceCoreCommand implements CommandExecutor {

	public static abstract class SpaceCoreSubCommand {
		protected SpaceCorePlugin plugin;

		public SpaceCoreSubCommand(SpaceCorePlugin p) {
			plugin = p;
		}

		public abstract List<String> names();

		public abstract String description();

		public abstract String usage();

		public abstract boolean isAdminCommand();

		public abstract boolean mustBePlayer();

		public abstract int maxArgs();

		public abstract int minArgs();

		public abstract void execute(String[] args, CommandSender sender);
	}

	private SpaceCorePlugin plugin;

	private List<SpaceCoreSubCommand> subCommands;

	public SpaceCoreCommand(SpaceCorePlugin p) {
		plugin = p;
		subCommands = new ArrayList<SpaceCoreSubCommand>();
		subCommands.add(new CreateWorldSubCommand(plugin));
		subCommands.add(new DeleteWorldSubCommand(plugin));
		subCommands.add(new ListWorldsSubCommand(plugin));
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 1) {
			for (SpaceCoreSubCommand subCommand : subCommands) {
				for (String name : subCommand.names()) {
					if (name.equalsIgnoreCase(args[0])) {
						processCommand(subCommand, sender, label, Arrays.copyOfRange(args, 1, args.length));
						return true;
					}
				}
			}
			sender.sendMessage(plugin.addPrefix(ChatColor.RED + "Unknown argument " + ChatColor.GRAY + args[0]));
		} else {
			showHelp(sender, label);
		}
		return true;
	}

	private void showHelp(CommandSender sender, String label) {
		sender.sendMessage(plugin.addPrefix(ChatColor.BOLD + plugin.getDescription().getFullName() + " command list:"));
		for (SpaceCoreSubCommand subCommand : subCommands) {
			showHelpSpecific(subCommand, sender, label);
		}
	}

	private void showHelpSpecific(SpaceCoreSubCommand subCommand, CommandSender sender, String label) {
		sender.sendMessage(plugin.addPrefix(String.format(ChatColor.DARK_GREEN + "/%s %s - %s", label, subCommand.usage(), subCommand.description())));
	}

	private void processCommand(SpaceCoreSubCommand subCommand, CommandSender sender, String label, String[] args) {
		if (subCommand.mustBePlayer() && !(sender instanceof Player)) {
			sender.sendMessage(plugin.addPrefix(ChatColor.RED + "You must be a player to use that command"));
			return;
		}

		if (subCommand.isAdminCommand() && !sender.hasPermission("spacecore.admin")) {
			sender.sendMessage(plugin.addPrefix(ChatColor.RED + "You must have admin permission to use that command"));
			return;
		}

		if (args.length > subCommand.maxArgs()) {
			sender.sendMessage(plugin.addPrefix(ChatColor.RED + "Too many arguments"));
			showHelpSpecific(subCommand, sender, label);
			return;
		}

		if (args.length < subCommand.minArgs()) {
			sender.sendMessage(plugin.addPrefix(ChatColor.RED + "Not enough arguments"));
			showHelpSpecific(subCommand, sender, label);
			return;
		}

		subCommand.execute(args, sender);
	}

}
