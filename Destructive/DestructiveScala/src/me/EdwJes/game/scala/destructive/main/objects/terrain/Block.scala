package me.EdwJes.game.scala.destructive.main.objects.terrain

import me.EdwJes.game.scala.destructive.main.objects.{Interactive, Renderable}
import me.EdwJes.game.scala.destructive.main.{Vector, Main}
import org.newdawn.slick.geom.Rectangle
import org.newdawn.slick.Graphics

class Block(pos:Vector, len:Int, wid:Int) extends Interactive(pos, 
		new Rectangle(pos.x, pos.y, len * Main.TILE_SIZE, wid * Main.TILE_SIZE))
		with Renderable{
  
  solid = true
  
  def draw(g:Graphics) {
    g.draw(body)
  }
}