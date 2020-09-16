package kotlin

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class KotlinMain(var javaPlugin: JavaPlugin) {
    val game:GameMain= GameMain(javaPlugin)
    fun enable() {
        addCommand(GameCommand(game))
        javaPlugin.scheduleAsyncRunnable(game,0,1)
    }

    fun disable() {

    }

    fun addCommand(command: ICommand) {
        javaPlugin.getCommand(command.getCommandName())!!.setExecutor(command)
    }
}

abstract class ICommand : CommandExecutor {
    abstract fun getCommandName(): String
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        return when (sender) {
            is Player -> {
                onPlayer(sender, command,label, args)
            }
            else -> {
                onServer(sender, command,label, args)
            }
        }
    }

    abstract fun onServer(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean
    abstract fun onPlayer(player: Player, command: Command, label: String, args: Array<out String>): Boolean
}