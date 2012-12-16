package me.EdwJes.game.scala.destructive.main.objects.terrain

import me.EdwJes.game.scala.destructive.main.{Vector, Main}
import org.newdawn.slick.geom.Polygon

class TriangleBlock(pos:Vector, len:Int, height:Int) extends Terrain(pos, 
    new Polygon(Array(
        pos.x, pos.y, pos.x + len*Main.TILE_SIZE, pos.y,
        pos.x + len*Main.TILE_SIZE, pos.y + height*Main.TILE_SIZE))) {
  
  bodyOffset.y = Main.TILE_SIZE * height
  
}