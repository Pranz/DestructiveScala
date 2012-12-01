package me.EdwJes.game.scala.destructive.main.objects

import org.newdawn.slick.Graphics
import org.newdawn.slick.geom.Shape
import me.EdwJes.game.scala.destructive.main.Vector

class TestObject( position:Vector, body:Shape) extends Interactive(position, body) 
	with Renderable with Physical {
  
  val V = Vector
  
  var gravity      = .0f
  var movement     = V(2, 1.8f)
  var accerelation = V(0,0)
  friction         = 0.02

  def draw(g: Graphics): Unit = {
    g.draw(body)
  }

  override def update(): Unit = {
    super.update
  }
  
  

}