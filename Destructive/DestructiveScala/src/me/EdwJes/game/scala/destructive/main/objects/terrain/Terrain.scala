package me.EdwJes.game.scala.destructive.main.objects.terrain

import me.EdwJes.game.scala.destructive.main.objects.{Interactive, Renderable}
import me.EdwJes.game.scala.destructive.main.Vector
import org.newdawn.slick.geom.Shape
import org.newdawn.slick.Graphics

abstract class Terrain(pos:Vector, bd:Shape) extends Interactive(pos, bd)
	with Renderable{
  
  solid = true
  
  def draw(g:Graphics) {
    g.draw(body)
  }

}