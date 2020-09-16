package com.bun133.placechooseyou;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static org.bukkit.Material.*;

public class PlaceChooser extends BukkitRunnable {
    public static final List<Material> safeSet = Arrays.asList(
            GRASS_BLOCK,
            DIRT,
            SAND,
            SANDSTONE,
            DARK_OAK_LOG,
            IRON_BLOCK,
            GOLD_BLOCK,
            DIAMOND_BLOCK,
            EMERALD_BLOCK,
            STONE,
            COBBLESTONE,
            CRAFTING_TABLE
    );

    public JavaPlugin plugin;
    public ResourceTranslator translator;
    public Long ticks = 0L;
    public Long changeTick = 1200L * 3;
    public Material safe = GRASS_BLOCK;
    private boolean isStarting = false;

    public PlaceChooser(JavaPlugin plugin) throws FileNotFoundException {
        this.plugin = plugin;
//        plugin.getLogger().info("DataFolder:"+plugin.getDataFolder().getAbsolutePath());
        this.translator = new ResourceTranslator(plugin.getResource("ja_jp.json"));
        this.init();
    }

    public static void sendTitle(Player p, String data) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(data));
    }

    public static void broadCastTitle(String s) {
        Bukkit.getOnlinePlayers()
                .forEach((it) -> {
                    sendTitle(it, s);
                });
    }

    private void init() {
        runTaskTimer(plugin, 10, 1);
//        Bukkit.getScheduler().scheduleSyncRepeatingTask();
    }

    public void setStatus(boolean b) {
        if (b) {
            isStarting = true;
        } else {
            isStarting = false;
            ticks = 0L;
        }
    }

    @Override
    public void run() {
        if (!isStarting) return;
        ++ticks;
        if (ticks >= changeTick) {
            checkSafe();
            changeSafe();
            ticks-=changeTick;
        }

        broadCastTitle("" + ChatColor.BOLD + translator.get(safe.getKey()) + " " +((changeTick - ticks) / 20));
    }

    private boolean countNear() {
        return ticks + 200 >= changeTick;
    }

    private void checkSafe() {
        Bukkit.getOnlinePlayers().stream()
                .filter(Objects::nonNull)
                .map((it) -> new DataSet<Player, Block>(it, getBelowBlock(it)))
                .filter((it) -> it.v != null)
                .forEach((it) -> {
                    if (it.v.getType().equals(safe)) {
                        it.t.sendMessage(ChatColor.BLUE + "SUCCESS");
                        it.t.playSound(it.t.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, .0f,0.0f);
                    } else {
                        it.t.sendMessage(ChatColor.RED + "FAILURE");
                        it.t.playSound(it.t.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f,-10.0f);
                        it.t.damage(1000000000);
                    }
                    it.t.sendMessage("Your Below Block is "+it.v.getType().name());
                });
    }

    public Block getBelowBlock(Player player) {
        final int x = player.getLocation().getBlockX();
        final int z = player.getLocation().getBlockZ();
        int y = player.getLocation().getBlockY();
        for (; 0 < y; y--) {
            if (!player.getWorld().getBlockAt(
                    x, y, z
            ).getType().equals(Material.AIR)) {
                return player.getWorld().getBlockAt(x, y, z);
            }
        }
        return null;
    }

    public void changeSafe() {
        safe = safeSet.get(new Random().nextInt(safeSet.size() - 1));
        Bukkit.broadcastMessage("Next Up is:" + safe.name());
    }

    public void setMin(Long min){
        this.changeTick = 1200 *min;
    }

    public void setSec(Long min){
        this.changeTick = 20 * min;
    }
}
