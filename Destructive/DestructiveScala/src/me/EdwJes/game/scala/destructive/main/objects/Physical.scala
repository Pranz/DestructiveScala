package me.EdwJes.game.scala.destructive.main.objects

import me.EdwJes.game.scala.destructive.main.{Vector, NullVector}
import collection.mutable.ArrayBuffer
import me.EdwJes.game.scala.destructive.main.objects.entities.Entity

trait Physical extends Interactive {
  
  (Physical list) += this
  
  var movement:Vector
  var accerelation:Vector
  var gravity:Float
  var friction:Double = 0
  
  def hspeed = movement.x
  def hspeed_= (hsp:Float):Unit = 
    movement.x = hsp
    
  def vspeed = movement.y
  def vspeed_= (hsp:Float):Unit = 
    movement.y = hsp
  
  override def update {
    super.update
    applyForces
  }
  
  def velocity = movement.length
  def velocity_= (vel:Double):Unit =  movement.length = vel;
  
  
  def applyForces {
    movement.y += gravity
    movement   += accerelation
    exertForce(movement)
    move(movement)
    if (friction != 0) velocity = velocity - friction
  }
  
  def exertForce(force:Vector) {
    if(solid && force != NullVector){
      val objs = allPlaceMeetingList(position.x + force.x, position.y + force.y - 1, Entity list)
      objs foreach {(x) => x.position+= force}
    }
    
  }
  

  override def destroy {
    super.destroy
    (Physical list) -= this
  }


}

object Physical{
  val list:   ArrayBuffer[Physical] = ArrayBuffer()

}

