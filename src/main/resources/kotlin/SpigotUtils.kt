package kotlin

import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.entity.Player

fun sendTitle(titleFor: Player, s: String) {
    sendTitle(titleFor, s, ChatMessageType.ACTION_BAR)
}

fun sendTitle(titleFor: Player, s: String, type: ChatMessageType) {
    titleFor.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent(s));
}

fun sendTitle(s: String) {
    Bukkit.getServer().onlinePlayers.forEach {
        sendTitle(it, s)
    }
}

fun sendTitle(s: String, type: ChatMessageType) {
    Bukkit.getServer().onlinePlayers.forEach {
        sendTitle(it, s, type)
    }
}