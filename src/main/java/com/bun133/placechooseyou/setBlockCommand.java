package com.bun133.placechooseyou;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class setBlockCommand implements CommandExecutor, Listener {

    public PlaceChooser chooser;
    public setBlockCommand(PlaceChooser chooser){this.chooser=chooser;}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            if(((Player)sender).isOp()){
                Inventory inventory = Bukkit.createInventory((Player)sender, 9,"SetBlock");
                ((Player) sender).openInventory(inventory);
                return true;
            }
            return false;
        }
        return false;
    }

    @EventHandler
    public void onItemAdd(InventoryDragEvent e){
        if(e.getView().getTitle().equals("SetBlock")){
            setBlock(e.getCursor());
            e.getWhoClicked().closeInventory();
        }
    }

    public void setBlock(ItemStack cursor){
        chooser.safe = cursor.getType();
    }
}
