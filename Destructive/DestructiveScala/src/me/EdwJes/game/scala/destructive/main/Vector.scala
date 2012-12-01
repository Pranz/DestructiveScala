package me.EdwJes.game.scala.destructive.main

case class Vector(var x:Float, var y:Float) {
  
  def length = math sqrt(x * x + y * y)
  def length_= (newl:Double):Unit = {
    if (newl == 0) return {}
    if (length <= math.abs(newl) ) return {
      x = 0
      y = 0
    }
    else return {
    	val dir = direction
        x = (newl * math.sin(dir)).toFloat
        y = (newl * math.cos(dir)).toFloat
    }

  }
  
  def direction = math atan2(x, y)
  
  def +(v:Vector):Vector = Vector(this.x + v.x, this.y + v.y)
  def *(n:Float):Vector = Vector(this.x * n, this.y * n)
  def unary_- = Vector(-x, -y)
  def toTuple = (x, y)
  
  override def toString = x.toString + ", " + y.toString
  
}

case class PolarVector(direction:Double, length:Double)

object NullVector extends Vector(0, 0)