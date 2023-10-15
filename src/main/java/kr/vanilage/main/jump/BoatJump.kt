package kr.vanilage.main.jump

import kr.vanilage.main.Main
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.entity.Boat
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class BoatJump : Listener {
    @EventHandler
    fun onMove(e : PlayerMoveEvent) {
        if (e.player.vehicle != null && e.player.vehicle!!.type == EntityType.BOAT) {
            if (e.player.getTargetBlockFace(2) != null) {
                if (checkIce(e.player)) {
                    if (e.player.vehicle!!.location.block.getRelative(BlockFace.DOWN).type == Material.PACKED_ICE) {
                        val boat = e.player.world.spawn(e.player.vehicle!!.location.add(0.0, 1.5, 0.0), Boat::class.java)
                        e.player.vehicle!!.remove()
                        boat.velocity = e.player.location.direction.multiply(0.8)
                        boat.addPassenger(e.player)
                    }
                }
            }
        }
    }

    private fun checkIce(p : Player) : Boolean {
        return p.vehicle!!.location.block.getRelative(BlockFace.WEST).type == Material.PACKED_ICE || p.vehicle!!.location.block.getRelative(BlockFace.EAST).type == Material.PACKED_ICE || p.vehicle!!.location.block.getRelative(BlockFace.NORTH).type == Material.PACKED_ICE || p.vehicle!!.location.block.getRelative(BlockFace.SOUTH).type == Material.PACKED_ICE
    }
}