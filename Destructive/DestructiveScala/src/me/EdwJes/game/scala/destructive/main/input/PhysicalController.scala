package me.EdwJes.game.scala.destructive.main.input

import me.EdwJes.game.scala.destructive.main.objects.Physical
import org.newdawn.slick.Input

class PhysicalController(obj:Physical, playerID:Int) extends Control(playerID) {
  
  val speed = 3

  def handleKeys(input:Input): Unit = {
    if (input.isKeyDown(key(Control.Key.MOVE_LEFT)))  obj.position.x -= speed
    if (input.isKeyDown(key(Control.Key.MOVE_RIGHT))) obj.position.x += speed
    if (input.isKeyDown(key(Control.Key.MOVE_DOWN)))  obj.position.y += speed
    if (input.isKeyDown(key(Control.Key.MOVE_UP)))    obj.position.y -= speed
    
  }
  
  def keyPressed(key:Int, keyChar:Char){}
  def keyReleased(key:Int, keyChar:Char){}

}