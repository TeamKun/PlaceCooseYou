package com.bun133.placechooseyou;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class setBlockCommand implements CommandExecutor, Listener {

    public PlaceChooser chooser;

    public setBlockCommand(PlaceChooser chooser) {
        this.chooser = chooser;
    }

    private Inventory inventory;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            if (((Player) sender).isOp()) {
                inventory = Bukkit.createInventory((Player) sender, 9, "SetBlock");
                ((Player) sender).openInventory(inventory);
                return true;
            }
            return false;
        }
        return false;
    }

    @EventHandler
    public void onItemAdd(InventoryCloseEvent event) {
        Inventory inv = event.getInventory();
        if (inv.equals(inventory)) {
            Stream.of(inv.getContents()).filter(e -> e != null).findFirst().ifPresent(e -> {
                setBlock(e);
                chooser.setStatus(true);
            });
        }
    }

    public void setBlock(ItemStack cursor) {
        chooser.safe = cursor.getType();
    }
}
