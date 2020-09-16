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
        sender.sendMessage("ここに立て: "+chooser.safe.name());
        sender.sendMessage("残り時間: "+chooser.ticks/20 + "秒");
        return true;
    }
}
