package me.EdwJes.game.scala.destructive.main.objects.entities

import org.newdawn.slick.geom.Rectangle
import me.EdwJes.game.scala.destructive.main.Vector

class Humanoid(pos:Vector) extends Entity(pos, new Rectangle(0,0,24,56)) {
  
  var jumpPower    = 6f
  

}