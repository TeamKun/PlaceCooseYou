package com.bun133.placechooseyou.legacy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 4, 0},
        bv = {1, 0, 3},
        k = 2,
        d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\"\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u001a\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\"\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\f"},
        d2 = {"registerListener", "", "Lorg/bukkit/plugin/java/JavaPlugin;", "listener", "Lorg/bukkit/event/Listener;", "scheduleAsyncRunnable", "runnable", "Lorg/bukkit/scheduler/BukkitRunnable;", "delay", "", "period", "scheduleRunnable", "PlaceCooseYou"}
)
public final class ExtentionKt {
    public static final void registerListener(@NotNull JavaPlugin $this$registerListener, @NotNull Listener listener) {
        Intrinsics.checkNotNullParameter($this$registerListener, "$this$registerListener");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Server var10000 = $this$registerListener.getServer();
        Intrinsics.checkNotNullExpressionValue(var10000, "server");
        var10000.getPluginManager().registerEvents(listener, (Plugin)$this$registerListener);
    }

    public static final void scheduleRunnable(@NotNull JavaPlugin $this$scheduleRunnable, @NotNull BukkitRunnable runnable, long delay, long period) {
        Intrinsics.checkNotNullParameter($this$scheduleRunnable, "$this$scheduleRunnable");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        runnable.runTaskTimer((Plugin)$this$scheduleRunnable, delay, period);
    }

    public static final void scheduleAsyncRunnable(@NotNull JavaPlugin $this$scheduleAsyncRunnable, @NotNull BukkitRunnable runnable, long delay, long period) {
        Intrinsics.checkNotNullParameter($this$scheduleAsyncRunnable, "$this$scheduleAsyncRunnable");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        runnable.runTaskTimerAsynchronously((Plugin)$this$scheduleAsyncRunnable, delay, period);
    }

    public static final void scheduleRunnable(@NotNull JavaPlugin $this$scheduleRunnable, @NotNull BukkitRunnable runnable, long delay) {
        Intrinsics.checkNotNullParameter($this$scheduleRunnable, "$this$scheduleRunnable");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        runnable.runTaskLater((Plugin)$this$scheduleRunnable, delay);
    }

    public static final void scheduleAsyncRunnable(@NotNull JavaPlugin $this$scheduleAsyncRunnable, @NotNull BukkitRunnable runnable, long delay) {
        Intrinsics.checkNotNullParameter($this$scheduleAsyncRunnable, "$this$scheduleAsyncRunnable");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        runnable.runTaskLaterAsynchronously((Plugin)$this$scheduleAsyncRunnable, delay);
    }
}
