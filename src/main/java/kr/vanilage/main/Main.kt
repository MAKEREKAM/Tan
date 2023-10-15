package kr.vanilage.main

import kr.vanilage.main.jump.BoatJump
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        lateinit var plugin : JavaPlugin
    }
    override fun onEnable() {
        plugin = this
        Bukkit.getConsoleSender().sendMessage("Hello, World!")
        Bukkit.getPluginManager().registerEvents(BoatJump(), this)
    }
}