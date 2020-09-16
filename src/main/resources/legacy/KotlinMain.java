// KotlinMain.java
package com.bun133.placechooseyou.legacy;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 4, 0},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004¨\u0006\u0012"},
        d2 = {"Lcom/bun133/placechooseyou/KotlinMain;", "", "javaPlugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "game", "Lcom/bun133/placechooseyou/GameMain;", "getGame", "()Lcom/bun133/placechooseyou/GameMain;", "getJavaPlugin", "()Lorg/bukkit/plugin/java/JavaPlugin;", "setJavaPlugin", "addCommand", "", "command", "Lcom/bun133/placechooseyou/ICommand;", "disable", "enable", "PlaceCooseYou"}
)
public final class KotlinMain {
    @NotNull
    private final GameMain game;
    @NotNull
    private JavaPlugin javaPlugin;

    public KotlinMain(@NotNull JavaPlugin javaPlugin) {
        Intrinsics.checkNotNullParameter(javaPlugin, "javaPlugin");
        this.javaPlugin = javaPlugin;
        this.game = new GameMain(this.javaPlugin);
    }

    @NotNull
    public final GameMain getGame() {
        return this.game;
    }

    public final void enable() {
        this.addCommand((ICommand) (new GameCommand(this.game)));
        ExtentionKt.scheduleAsyncRunnable(this.javaPlugin, (BukkitRunnable) this.game, 0L, 1L);
    }

    public final void disable() {
    }

    public final void addCommand(@NotNull ICommand command) {
        Intrinsics.checkNotNullParameter(command, "command");
        PluginCommand var10000 = this.javaPlugin.getCommand(command.getCommandName());
        Intrinsics.checkNotNull(var10000);
        var10000.setExecutor((CommandExecutor) command);
    }

    @NotNull
    public final JavaPlugin getJavaPlugin() {
        return this.javaPlugin;
    }

    public final void setJavaPlugin(@NotNull JavaPlugin var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.javaPlugin = var1;
    }
}
