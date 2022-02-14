package com.github.pocketkid2.spacecore.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;

import com.github.pocketkid2.spacecore.SpaceCorePlugin;
import com.github.pocketkid2.spacecore.commands.SpaceCoreCommand.SpaceCoreSubCommand;

public class ListWorldsSubCommand extends SpaceCoreSubCommand {

	public ListWorldsSubCommand(SpaceCorePlugin plugin) {
		super(plugin);
	}

	@Override
	public List<String> names() {
		return Arrays.asList("listworlds", "lw");
	}

	@Override
	public String usage() {
		return "listworlds/lw [filter]";
	}

	@Override
	public boolean isAdminCommand() {
		return true;
	}

	@Override
	public boolean mustBePlayer() {
		return false;
	}

	@Override
	public int maxArgs() {
		return 1;
	}

	@Override
	public int minArgs() {
		return 0;
	}

	@Override
	public void execute(String label, String[] args, CommandSender sender) {
	}

}
