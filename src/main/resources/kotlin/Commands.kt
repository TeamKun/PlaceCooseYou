package kotlin

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GameCommand(val game:GameMain): ICommand() {
    override fun getCommandName(): String = "game"

    override fun onServer(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        return when(args[0]){
            "start" -> {game.isStarting=true;true
            }
            "stop" -> {game.isStarting=false;true
            }
            else -> {
                false
            }
        }
    }

    override fun onPlayer(player: Player, command: Command, label: String, args: Array<out String>): Boolean {
        if(!player.isOp){
            player.sendMessage("You don't have enough perm!")
            return false
        }
        return when(args[0]){
            "start" -> {game.isStarting=true;true
            }
            "stop" -> {game.isStarting=false;true
            }
            else -> {
                false
            }
        }
    }

}