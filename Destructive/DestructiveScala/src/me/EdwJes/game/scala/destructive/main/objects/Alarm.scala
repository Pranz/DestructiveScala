package me.EdwJes.game.scala.destructive.main.objects

class Alarm(frames:Int, f:() => Unit, loop:Boolean = false) extends GameObject {
  
  if(frames == 0) execute

  var currentFrame = 1
  
  def update(){
    if (currentFrame >= frames) {
      execute
    }
    else currentFrame += 1
  }
  
  def execute {
    f()
    if (loop) currentFrame = 0
    else super.destroy
  }

}