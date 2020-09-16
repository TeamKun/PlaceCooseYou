package kotlin

import com.google.gson.Gson
import com.google.gson.JsonObject
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


class Translator(file:File){
    companion object{
        val INSTANCE:Translator= Translator(File("src\\main\\resources\\ja_jp.json"))
    }
    var map:JsonObject = Gson().fromJson(BufferedReader(FileReader(file)),JsonObject::class.java)
    fun get(key:String):String{
        return map.get(key).asString
    }
}