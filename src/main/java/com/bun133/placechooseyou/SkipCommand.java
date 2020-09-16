package com.bun133.placechooseyou;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SkipCommand implements CommandExecutor {
    public PlaceChooser chooser;
    public SkipCommand(PlaceChooser chooser){this.chooser=chooser;}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            if(((Player)sender).isOp()){
                return skip();
            }
        }else return skip();
        return false;
    }

    private boolean skip() {
        chooser.ticks=chooser.changeTick;
        Bukkit.broadcastMessage("Skipped!");
        return true;
    }
}
