// GameMain.java
package com.bun133.placechooseyou.legacy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Consumer;

@Metadata(
        mv = {1, 4, 0},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\n¨\u0006 "},
        d2 = {"Lcom/bun133/placechooseyou/GameMain;", "Lorg/bukkit/scheduler/BukkitRunnable;", "javaPlugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "changeTick", "", "getChangeTick", "()J", "setChangeTick", "(J)V", "isStarting", "", "()Z", "setStarting", "(Z)V", "safeBlock", "Lorg/bukkit/Material;", "getSafeBlock", "()Lorg/bukkit/Material;", "setSafeBlock", "(Lorg/bukkit/Material;)V", "ticksCount", "getTicksCount", "setTicksCount", "changeSafe", "", "checkSafe", "run", "tickComing", "update", "Companion", "PlaceCooseYou"}
)
public final class GameMain extends BukkitRunnable {
    private boolean isStarting;
    private long changeTick;
    private long ticksCount;
    @NotNull
    private Material safeBlock;
    @NotNull
    private static final Material[] safeBlocks;
    public final boolean isStarting() {
        return this.isStarting;
    }

    public final void setStarting(boolean var1) {
        this.isStarting = var1;
    }

    public void run() {
        if (this.isStarting) {
            this.update();
        }

    }

    public final long getChangeTick() {
        return this.changeTick;
    }

    public final void setChangeTick(long var1) {
        this.changeTick = var1;
    }

    public final long getTicksCount() {
        return this.ticksCount;
    }

    public final void setTicksCount(long var1) {
        this.ticksCount = var1;
    }

    @NotNull
    public final Material getSafeBlock() {
        return this.safeBlock;
    }

    public final void setSafeBlock(@NotNull Material var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.safeBlock = var1;
    }

    private final void update() {
        ++this.ticksCount;
        long var10000 = this.ticksCount;
        if (this.ticksCount >= this.changeTick) {
            this.checkSafe();
            this.changeSafe();
            this.ticksCount -= this.changeTick;
        }

        if (this.tickComing() && (this.ticksCount - this.changeTick) % (long)20 == 0L) {
            SpigotUtilsKt.sendTitle("" + (this.ticksCount - this.changeTick) % (long)20);
        }

    }

    private final boolean tickComing() {
        return this.ticksCount + (long)200 >= this.changeTick;
    }
    private final Block getBelowBlock(Block block){
        if(block.getBlockData().getMaterial()!=Material.AIR){
            return block;
        }else{
            for (int i = block.getLocation().getBlockY(); 0 < i; i--) {
                if(block.getWorld().getBlockAt(block.getLocation().getBlockX(),i,block.getLocation().getBlockZ()).getBlockData().getMaterial()!=Material.AIR){
                    return block.getWorld().getBlockAt(block.getLocation().getBlockX(),i,block.getLocation().getBlockZ());
                }
            }
        }
        return null;
    }
    private final void checkSafe() {
        Bukkit.getOnlinePlayers().stream().map((it) -> new DoubleSet<>(it,getBelowBlock(it.getWorld().getBlockAt(it.getLocation())))).filter((it) -> {return it.getV()!=null;}).forEach((Consumer)(new Consumer() {
            // $FF: synthetic method
            // $FF: bridge method
            public void accept(Object var1) {
                this.accept((DoubleSet<Player, Object>)var1);
            }

            public final void accept(DoubleSet<Player, Object> it) {
                Material var10000 = GameMain.this.getSafeBlock();
                Object var10001 = it.getV();
                Intrinsics.checkNotNull(var10001);
                Object var2;
                if (var10000 == ((Block)var10001).getType()) {
                    var2 = it.getT();
                    Intrinsics.checkNotNullExpressionValue(var2, "it.t");
                    SpigotUtilsKt.sendTitle((Player)var2, "" + ChatColor.BLUE + "SUCCESS");
                } else {
                    var2 = it.getT();
                    Intrinsics.checkNotNullExpressionValue(var2, "it.t");
                    SpigotUtilsKt.sendTitle((Player)var2, "" + ChatColor.RED + "FILED");
                    (it.getT()).damage(100000.0D);
                }

            }
        }));
    }

    private final void changeSafe() {
        this.safeBlock = safeBlocks[(new Random()).nextInt(safeBlocks.length)];
        StringBuilder var10000 = (new StringBuilder()).append("NextBlock is:");
        Translator var10001 = Translator.INSTANCE;
        String var10002 = this.safeBlock.getKey().toString();
        Intrinsics.checkNotNullExpressionValue(var10002, "safeBlock.key.toString()");
        Bukkit.broadcastMessage(var10000.append(var10001.get(var10002)).toString());
    }

    public GameMain(@NotNull JavaPlugin javaPlugin) {
        Intrinsics.checkNotNullParameter(javaPlugin, "javaPlugin");
        this.changeTick = 1200L;
        this.safeBlock = Material.DIRT;
    }

    static {
        safeBlocks = new Material[]{Material.DIRT, Material.SAND, Material.SANDSTONE, Material.GRASS_BLOCK};
    }
}
