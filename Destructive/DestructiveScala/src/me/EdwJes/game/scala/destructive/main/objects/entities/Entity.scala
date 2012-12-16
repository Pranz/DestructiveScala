package me.EdwJes.game.scala.destructive.main.objects.entities

import me.EdwJes.game.scala.destructive.main.objects.{Physical, Interactive, Renderable, Alarm}
import me.EdwJes.game.scala.destructive.main.Vector
import org.newdawn.slick.geom.Shape
import org.newdawn.slick.Graphics
import collection.mutable.ArrayBuffer

abstract class Entity( pos:Vector, body:Shape) extends Interactive(pos, body) with Physical 
	with Renderable{
  
  (Entity list) += this
  
  val V = Vector
  private val speedMods = ArrayBuffer[Float]()
  
  private var airspdf = 0.1f
  var airFricFactor  = 0f
  
  def airSpeedFactor:Float = {
    if(vspeed < 0) 0
    else airspdf
  }
  
  var movement     = V(0, 0)
  var accerelation = V(0, 0)
  var gravity      = 0.15f
  var moving       = false
  var jumpPower:Float
  private var spd  = 0.6f
  private var hfr  = 0.3f

  def hfriction = hfr * speedMod
  def hfriction_=(value:Float):Unit = {
    hfr = value
  }
  
  var vfriction = 0
  
  var speedMod = 1f //calculates for every update due to performance.
  
  var maxhspd   = 3f
  def maxhSpeed:Float = {
    if (onGround) speedMod * maxhspd
    else speedMod * maxhspd * airSpeedFactor * 5
  }
  
  def speed = speedMod * spd
  def speed_=(value:Float):Unit = {
    spd = value
  }
  
  def addSpeedMod(spd:Float, duration:Int = -1) {
    speedMods += spd
    if(duration != -1) new Alarm(duration, () => speedMods -= spd, false)
  }
  
  def removeSpeedMod(spd:Float){
    speedMods -= spd
  }
  
  def draw(g:Graphics) {
    g.draw(body)
  }
  
  override def update {
    super.update
    applyHFriction
    speedMod = speedMods.foldLeft(1.0f){_ * _}
  }
  
  def applyHFriction {
    val hfric = {
      if (onGround) hfriction
      else hfriction * airFricFactor
    }
    if(hfric != 0){
      if (math.abs(hspeed) < hfric) hspeed = 0
      else hspeed -= math.signum(hspeed) * hfric
    }
    else moving = false
  }
  
  def applyVFriction {
    val vfric = {
      if (onGround) vfriction
      else vfriction * airFricFactor
    }
    if(vfric != 0){
      if (math.abs(hspeed) < vfric) hspeed = 0
      else hspeed -= math.signum(hspeed) * vfric
    }
    else moving = false
  }
  
  def run(dir:Int) {
    val spd = {
      if (onGround) speed
      else speed * airSpeedFactor
    }
    moving = true
    if ((math.abs(hspeed + spd*dir)) >= maxhSpeed && dir == Math.signum(hspeed)){
      if (spd > (math.abs(hspeed + spd*dir)) - maxhSpeed) hspeed = maxhSpeed * math.signum(hspeed)
    }
    else hspeed += spd*dir
  }
  
  def jump() {
    if(onGround){
      vspeed -= jumpPower
    }
  }
  
  def moveXtowardsOther(dir:Int, other:Interactive) {
    if(!collidesOther(position.x + dir, position.y, other)){
      position.x += dir
      moveXtowardsOther(dir, other)
    }
  }
  
  def moveYtowardsOther(dir:Int, other:Interactive) {
    if(!collidesOther(position.x, position.y + dir, other)){
      position.y += dir
      moveXtowardsOther(dir, other)
    }
  }
  
  def moveX(x:Float) {
    if (math.abs(x) >= 1){
      if (collidesAny(position.x + x, position.y, true)) {
        if(!collidesAny(position.x + Math.signum(x), position.y - 1, true)){
          position.y -= 2
        }
        else hspeed = 0
        
        moveX(x - math.signum(x))
      }
      else position.x += x
    }
    else if (!collidesAny(position.x + math.signum(x), position.y, true)) position.x += x
    else if(!collidesAny(position.x + Math.signum(x), position.y - 1, true)){
          position.y -= 2
        }
    else hspeed = 0
  }
  
  def moveY(y:Float) {
    if (math.abs(y) >= 1){
      if (collidesAny(position.x, position.y + y, true)){
        moveY(y - math.signum(y))
        vspeed = 0
      }
      else position.y += y
    }
    else if (!collidesAny(position.x, position.y + math.signum(y), true)) position.y += y
    else vspeed = 0
  }
  
  override def move(dpos:Vector):Unit = {
    moveX(dpos.x); moveY(dpos.y)
  }


}

object Entity{
    val LEFT  = -1
    val RIGHT =  1
    val list:ArrayBuffer[Entity] = ArrayBuffer()
  }