package me.EdwJes.game.scala.destructive.main.input

import org.newdawn.slick.{Input, MouseListener}
import me.EdwJes.game.scala.destructive.main.objects.entities.Entity
import me.EdwJes.game.scala.destructive.main.Main

class EntityControl(ent:Entity, playerID:Int) extends Control(playerID) with MouseListener {
  
  Main.input.addMouseListener(this)

  def handleKeys(input: Input): Unit = {
    if (input.isKeyDown(key(Control.Key.MOVE_LEFT)))  ent.run(Entity.LEFT)
    if (input.isKeyDown(key(Control.Key.MOVE_RIGHT))) ent.run(Entity.RIGHT)
  }
  
  def keyPressed(key:Int, keyChar:Char){
    key match {
      case Input.KEY_SPACE  => ent.jump
      case Input.KEY_LSHIFT => ent.addSpeedMod(0.5f) 
      
      case _ => {}
    }
  }
  def keyReleased(key:Int, keyChar:Char){
    key match {
      case Input.KEY_LSHIFT => ent.removeSpeedMod(0.5f)
      
      case _ => {}
    }
  }
  
  def mouseClicked(button:Int, x:Int, y:Int, clickCount:Int) {}
  def mouseDragged(oldx:Int, oldy:Int, newx:Int, newy:Int) {}
  def mouseMoved(oldx:Int, oldy:Int, newx:Int, newy:Int) {}
  def mousePressed(button:Int, x:Int, y:Int) {
  }
  def mouseReleased(button:Int, x:Int, y:Int) {}
  def mouseWheelMoved(delta:Int) {}

}