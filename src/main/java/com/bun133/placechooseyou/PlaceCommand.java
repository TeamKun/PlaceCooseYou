package com.bun133.placechooseyou;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlaceCommand implements CommandExecutor {
    public PlaceChooser chooser;
    public PlaceCommand(PlaceChooser chooser){
        this.chooser=chooser;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            if(((Player)sender).isOp()){
                return extract(sender, command, label, args);
            }else{
                sender.sendMessage("You don't have enough perm!");
            }
        }else return extract(sender, command, label, args);
        return false;
    }

    public boolean extract(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args){
        if(args.length!=1){
            return false;
        }else{
            switch (args[0]){
                case "start":
                    chooser.setStatus(true);
                    return true;
                case "stop":
                    chooser.setStatus(false);
                    return true;
            }
        }
        return false;
    }
}
