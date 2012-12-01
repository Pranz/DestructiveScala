package me.EdwJes.game.scala.destructive.main.objects.terrain

import me.EdwJes.game.scala.destructive.main.Vector

class VerticalScrollingBlock(pos:Vector, tileHeight:Int, blockID:Int, spdFactor:Double = 0.02, len:Int = 6, wid:Int = 2) 
	extends ControllableBlock(pos, len, wid, blockID:Int) {
  
  val switch:Array[Boolean] = null
  val property:Array[Property] = Array(Property(1000))
  
  val tileStep = tileHeight.toFloat / property(0).max
  val oPosY = position.y
  def targetPos  = property(0).curVal * tileStep
  def currentPos = position.y - oPosY
  
  override def update{
    super.update
    movement.y = -((targetPos + currentPos) * spdFactor).toFloat
  }

}