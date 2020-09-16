// ICommand.java
package com.bun133.placechooseyou.legacy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 4, 0},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\rH\u0016¢\u0006\u0002\u0010\u000eJ5\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\rH&¢\u0006\u0002\u0010\u0012J5\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\rH&¢\u0006\u0002\u0010\u000e¨\u0006\u0014"},
        d2 = {"Lcom/bun133/placechooseyou/ICommand;", "Lorg/bukkit/command/CommandExecutor;", "()V", "getCommandName", "", "onCommand", "", "sender", "Lorg/bukkit/command/CommandSender;", "command", "Lorg/bukkit/command/Command;", "label", "args", "", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "onPlayer", "player", "Lorg/bukkit/entity/Player;", "(Lorg/bukkit/entity/Player;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "onServer", "PlaceCooseYou"}
)
public abstract class ICommand implements CommandExecutor {
    @NotNull
    public abstract String getCommandName();

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(args, "args");
        return sender instanceof Player ? this.onPlayer((Player) sender, command, label, args) : this.onServer(sender, command, label, args);
    }

    public abstract boolean onServer(@NotNull CommandSender var1, @NotNull Command var2, @NotNull String var3, @NotNull String[] var4);

    public abstract boolean onPlayer(@NotNull Player var1, @NotNull Command var2, @NotNull String var3, @NotNull String[] var4);
}