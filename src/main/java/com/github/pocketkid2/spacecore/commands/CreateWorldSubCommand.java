package com.github.pocketkid2.spacecore.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;

import com.github.pocketkid2.spacecore.SpaceCorePlugin;
import com.github.pocketkid2.spacecore.commands.SpaceCoreCommand.SpaceCoreSubCommand;

public class CreateWorldSubCommand extends SpaceCoreSubCommand {

	public CreateWorldSubCommand(SpaceCorePlugin plugin) {
		super(plugin);
	}

	@Override
	public List<String> names() {
		return Arrays.asList("createworld", "cw");
	}

	@Override
	public String description() {
		return "Creates a world with the given name and generator type";
	}

	@Override
	public String usage() {
		return "createworld/cw <name> <type>";
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
		return 2;
	}

	@Override
	public int minArgs() {
		return 2;
	}

	@Override
	public void execute(String[] args, CommandSender sender) {
		// TODO Auto-generated method stub

	}

}
