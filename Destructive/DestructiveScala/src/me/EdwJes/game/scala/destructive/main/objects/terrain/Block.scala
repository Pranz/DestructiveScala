package me.EdwJes.game.scala.destructive.main.objects.terrain

import me.EdwJes.game.scala.destructive.main.objects.Interactive
import me.EdwJes.game.scala.destructive.main.{Vector, Main}
import org.newdawn.slick.geom.Rectangle

case class Block(pos:Vector, len:Int, wid:Int) extends Terrain(pos, 
		new Rectangle(pos.x, pos.y, len * Main.TILE_SIZE, wid * Main.TILE_SIZE)){
  
}