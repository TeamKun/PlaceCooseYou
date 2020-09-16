package com.bun133.placechooseyou;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.bukkit.NamespacedKey;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ResourceTranslator {
    public JsonObject json;
    public ResourceTranslator(File file) throws FileNotFoundException {
        json = new Gson().fromJson(new FileReader(file),JsonObject.class);
    }

    public ResourceTranslator(InputStream stream){
        json = new Gson().fromJson(new BufferedReader(new InputStreamReader(stream, UTF_8)),JsonObject.class);
    }

    public String get(String key){
        String s=json.get(key).getAsString();
        if(s==null) System.out.println(""+key+" is not found!");
        return s;
    }

    public String get(NamespacedKey key) {
        return get("block."+key.getNamespace()+"."+key.getKey());
    }
}
