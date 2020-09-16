package com.bun133.placechooseyou;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class StatusCommand implements CommandExecutor {
    public PlaceChooser chooser;
    public StatusCommand(PlaceChooser chooser){
        this.chooser=chooser;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage("SafeBlock:"+chooser.safe.name());
        sender.sendMessage("Now Time is "+chooser.ticks/20);
        sender.sendMessage("Actually tick is "+chooser.ticks);
        return true;
    }
}
