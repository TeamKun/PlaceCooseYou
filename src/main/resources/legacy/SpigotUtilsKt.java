package com.bun133.placechooseyou.legacy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

@Metadata(
        mv = {1, 4, 0},
        bv = {1, 0, 3},
        k = 2,
        d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\b"},
        d2 = {"sendTitle", "", "s", "", "type", "Lnet/md_5/bungee/api/ChatMessageType;", "titleFor", "Lorg/bukkit/entity/Player;", "PlaceCooseYou"}
)
public final class SpigotUtilsKt {
    public static final void sendTitle(@NotNull Player titleFor, @NotNull String s) {
        Intrinsics.checkNotNullParameter(titleFor, "titleFor");
        Intrinsics.checkNotNullParameter(s, "s");
        sendTitle(titleFor, s, ChatMessageType.ACTION_BAR);
    }

    public static final void sendTitle(@NotNull Player titleFor, @NotNull String s, @NotNull ChatMessageType type) {
        Intrinsics.checkNotNullParameter(titleFor, "titleFor");
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter(type, "type");
        titleFor.spigot().sendMessage(ChatMessageType.ACTION_BAR, (BaseComponent)(new TextComponent(s)));
    }

    public static final void sendTitle(@NotNull String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        Server var10000 = Bukkit.getServer();
        Intrinsics.checkNotNullExpressionValue(var10000, "Bukkit.getServer()");
        Collection var7 = var10000.getOnlinePlayers();
        Intrinsics.checkNotNullExpressionValue(var7, "Bukkit.getServer().onlinePlayers");
        Iterable $this$forEach$iv = (Iterable)var7;
        boolean $i$f$forEach = false;
        Iterator var3 = $this$forEach$iv.iterator();

        while(var3.hasNext()) {
            Object element$iv = var3.next();
            Player it = (Player)element$iv;
            boolean var6 = false;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            sendTitle(it, s);
        }

    }

    public static final void sendTitle(@NotNull String s, @NotNull ChatMessageType type) {
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter(type, "type");
        Server var10000 = Bukkit.getServer();
        Intrinsics.checkNotNullExpressionValue(var10000, "Bukkit.getServer()");
        Collection var8 = var10000.getOnlinePlayers();
        Intrinsics.checkNotNullExpressionValue(var8, "Bukkit.getServer().onlinePlayers");
        Iterable $this$forEach$iv = (Iterable)var8;
        boolean $i$f$forEach = false;
        Iterator var4 = $this$forEach$iv.iterator();

        while(var4.hasNext()) {
            Object element$iv = var4.next();
            Player it = (Player)element$iv;
            boolean var7 = false;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            sendTitle(it, s, type);
        }

    }
}
