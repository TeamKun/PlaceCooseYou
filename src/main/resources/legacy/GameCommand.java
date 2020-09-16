package com.bun133.placechooseyou.legacy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 4, 0},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J5\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0011H\u0016¢\u0006\u0002\u0010\u0012J5\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0011H\u0016¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"},
        d2 = {"Lcom/bun133/placechooseyou/GameCommand;", "Lcom/bun133/placechooseyou/ICommand;", "game", "Lcom/bun133/placechooseyou/GameMain;", "(Lcom/bun133/placechooseyou/GameMain;)V", "getGame", "()Lcom/bun133/placechooseyou/GameMain;", "getCommandName", "", "onPlayer", "", "player", "Lorg/bukkit/entity/Player;", "command", "Lorg/bukkit/command/Command;", "label", "args", "", "(Lorg/bukkit/entity/Player;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "onServer", "sender", "Lorg/bukkit/command/CommandSender;", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "PlaceCooseYou"}
)
public final class GameCommand extends ICommand {
    @NotNull
    private final GameMain game;

    @NotNull
    public String getCommandName() {
        return "game";
    }

    public boolean onServer(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(args, "args");
        String var5 = args[0];
        boolean var10000;
        switch(var5.hashCode()) {
            case 3540994:
                if (var5.equals("stop")) {
                    this.game.setStarting(false);
                    var10000 = true;
                    return var10000;
                }
                break;
            case 109757538:
                if (var5.equals("start")) {
                    this.game.setStarting(true);
                    var10000 = true;
                    return var10000;
                }
        }

        var10000 = false;
        return var10000;
    }

    public boolean onPlayer(@NotNull Player player, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!player.isOp()) {
            player.sendMessage("You don't have enough perm!");
            return false;
        } else {
            String var5 = args[0];
            boolean var10000;
            switch(var5.hashCode()) {
                case 3540994:
                    if (var5.equals("stop")) {
                        this.game.setStarting(false);
                        var10000 = true;
                        return var10000;
                    }
                    break;
                case 109757538:
                    if (var5.equals("start")) {
                        this.game.setStarting(true);
                        var10000 = true;
                        return var10000;
                    }
            }

            var10000 = false;
            return var10000;
        }
    }

    @NotNull
    public final GameMain getGame() {
        return this.game;
    }

    public GameCommand(@NotNull GameMain game) {
        Intrinsics.checkNotNullParameter(game, "game");
        this.game = game;
    }
}
