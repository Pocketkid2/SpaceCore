package com.github.pocketkid2.spacecore.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;

import com.github.pocketkid2.spacecore.SpaceCorePlugin;
import com.github.pocketkid2.spacecore.commands.SpaceCoreCommand.SpaceCoreSubCommand;

public class DeleteWorldSubCommand extends SpaceCoreSubCommand {

	public DeleteWorldSubCommand(SpaceCorePlugin plugin) {
		super(plugin);
	}

	@Override
	public List<String> names() {
		return Arrays.asList("deleteworld", "dw");
	}

	@Override
	public String description() {
		return "Deletes the specified world";
	}

	@Override
	public String usage() {
		return "deleteworld/dw <name>";
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
		return 1;
	}

	@Override
	public void execute(String[] args, CommandSender sender) {
		// TODO Auto-generated method stub

	}

}
