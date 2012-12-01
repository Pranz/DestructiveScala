package me.EdwJes.game.scala.destructive.main.objects.terrain

import me.EdwJes.game.scala.destructive.main.Vector
import me.EdwJes.game.scala.destructive.main.objects.Physical

class PhysicalBlock(pos:Vector, len:Int, wid:Int) 
	extends Block(pos:Vector, len:Int, wid:Int) with Physical {
  
  val V = Vector
  
  var gravity = 0.0f
  
  var accerelation = V(0,0)
  var movement     = V(0,0)

}