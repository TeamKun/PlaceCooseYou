package com.bun133.placechooseyou;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class setTimeCommand implements CommandExecutor {
    public PlaceChooser chooser;
    public setTimeCommand(PlaceChooser chooser){
        this.chooser = chooser;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length!=1) return false;
        if(((Player)sender).isOp()){
            chooser.setSec((long) Integer.parseInt(args[0]));
        }
        return false;
    }
}
