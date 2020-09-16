package com.bun133.placechooseyou.legacy;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

import java.io.*;

@Metadata(
        mv = {1, 4, 0},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"},
        d2 = {"Lcom/bun133/placechooseyou/Translator;", "", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "map", "Lcom/google/gson/JsonObject;", "getMap", "()Lcom/google/gson/JsonObject;", "setMap", "(Lcom/google/gson/JsonObject;)V", "get", "", "key", "Companion", "PlaceCooseYou"}
)
public final class Translator {
    @NotNull
    public static Translator INSTANCE;

    static {
        try {
            INSTANCE = new Translator(new File("src\\main\\resources\\ja_jp.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    private JsonObject map;

    public Translator(@NotNull File file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "file");
        Object var10001 = (new Gson()).fromJson((Reader) (new BufferedReader((Reader) (new FileReader(file)))), JsonObject.class);
        Intrinsics.checkNotNullExpressionValue(var10001, "Gson().fromJson(Buffered…),JsonObject::class.java)");
        this.map = (JsonObject) var10001;
    }

    @NotNull
    public final JsonObject getMap() {
        return this.map;
    }

    public final void setMap(@NotNull JsonObject var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.map = var1;
    }

    @NotNull
    public final String get(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement var10000 = this.map.get(key);
        Intrinsics.checkNotNullExpressionValue(var10000, "map.get(key)");
        String var2 = var10000.getAsString();
        Intrinsics.checkNotNullExpressionValue(var2, "map.get(key).asString");
        return var2;
    }
}
