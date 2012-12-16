package me.EdwJes.game.scala.destructive.main.objects

import me.EdwJes.game.scala.destructive.main.{Vector, NullVector}
import collection.mutable.ArrayBuffer
import org.newdawn.slick.geom.Rectangle
import me.EdwJes.game.scala.destructive.main.objects.entities.Entity

trait Physical extends Interactive {
  
  implicit def extractPhysicalOption(option:Option[Physical]):Physical = option match {
    case Some(obj) => obj
    case None      => DefaultPhysical
  }
  
  (Physical list) += this
  
  var movement:Vector
  var accerelation:Vector
  var gravity:Float
  var friction:Double = 0
  
  var relativeObject:Option[Physical] = None
  var prvRelativeObject:Option[Physical] = None
  
  def hspeed = movement.x
  def hspeed_= (hsp:Float):Unit = 
    movement.x = hsp
    
  def vspeed = movement.y
  def vspeed_= (hsp:Float):Unit = 
    movement.y = hsp
  
  override def update {
    super.update
    if(relativeObject != prvRelativeObject){
      movement += prvRelativeObject.movement + (-relativeObject.movement)
    }
    applyForces
    prvRelativeObject = relativeObject
    relativeObject = None
    
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
      val objs = allPlaceMeetingList(position.x + force.x, position.y + force.y , Entity list)
      objs foreach {(o) =>
        o.relativeObject = Some(this)
        o.position += force
        }
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

object DefaultPhysical extends Interactive(NullVector, new Rectangle(0,0,0,0)) with Physical {
  
  var movement:Vector = Vector(0,0)
  var accerelation:Vector = Vector(0,0)
  var gravity:Float = 0
}