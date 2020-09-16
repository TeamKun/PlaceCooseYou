package kotlin

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import java.util.*

class GameMain(javaPlugin: JavaPlugin) : BukkitRunnable() {
    companion object{
        val safeBlocks:Array<Material> = arrayOf(Material.DIRT,Material.SAND,Material.SANDSTONE,Material.GRASS_BLOCK)
    }

    var isStarting:Boolean = false

    override fun run() {
        if(isStarting) update()
    }

    //1200Ticks = 1200/20 sec = 60 sec = 1 min
    var changeTick:Long = 1200
    var ticksCount:Long=0L
    var safeBlock:Material = Material.DIRT
    //EVERY TICK
    private fun update(){
        ++ticksCount
        if(ticksCount >= changeTick){
            checkSafe()
            changeSafe()
            ticksCount -= changeTick
        }
        if(tickComing()){
            if((ticksCount - changeTick) % 20 == 0L){
                sendTitle(""+(ticksCount - changeTick) % 20)
            }
        }
    }

    private fun tickComing(): Boolean {
        return ticksCount + 200 >= changeTick
    }

    private fun checkSafe() {
        Bukkit.getOnlinePlayers().stream().map {
            DoubleSet(it,it.getBelowBlock())
        }.filter {
            it.v!=null
        }.forEach {
            if(safeBlock === it.v!!.type){
                sendTitle(it.t,""+ChatColor.BLUE+"SUCCESS")
            }else{
                sendTitle(it.t,""+ChatColor.RED+"FILED")
                it.t.damage(100000.0)
            }
        }
    }

    private fun changeSafe() {
        safeBlock=safeBlocks[Random().nextInt(safeBlocks.size)]
        Bukkit.broadcastMessage("NextBlock is:"+Translator.INSTANCE.get(safeBlock.key.toString()))
    }
}

fun Player.getBelowBlock(): Block? {
    return this.location.getBelowBlock()
}

fun Location.getBelowBlock(): Block? {
    if(block.blockData.material!=Material.AIR){
        return block
    }else{
        for(i in blockY..0){
            if(world!!.getBlockAt(blockX,i,blockZ).blockData.material!=Material.AIR){
                return world!!.getBlockAt(blockX,i,blockZ)
            }
        }
    }
    return null
}