package kotlin

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

fun JavaPlugin.registerListener(listener: Listener) {
    server.pluginManager.registerEvents(listener, this)
}

fun JavaPlugin.scheduleRunnable(runnable: BukkitRunnable, delay: Long, period: Long) {
    runnable.runTaskTimer(this, delay, period)
}

fun JavaPlugin.scheduleAsyncRunnable(runnable: BukkitRunnable, delay: Long, period: Long) {
    runnable.runTaskTimerAsynchronously(this, delay, period)
}

fun JavaPlugin.scheduleRunnable(runnable: BukkitRunnable, delay: Long){
    runnable.runTaskLater(this,delay)
}

fun JavaPlugin.scheduleAsyncRunnable(runnable: BukkitRunnable, delay: Long) {
    runnable.runTaskLaterAsynchronously(this, delay)
}