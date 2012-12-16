package me.EdwJes.game.scala.destructive.main.input

import me.EdwJes.game.scala.destructive.main.Main
import me.EdwJes.game.scala.destructive.main.objects.GameObject
import org.newdawn.slick.{KeyListener, Input}
import collection.mutable.ArrayBuffer
import collection.immutable.HashMap

abstract class Control(playerID:Int) extends GameObject with KeyListener {
  
  def handleKeys(input:Input):Unit
  Main.input.addKeyListener(this)
  
  final def update {
    handleKeys(Main.input)
  }
  
  def key (k:Control.Key.Value) = Control.keyMap(playerID, k)
  
  def isAcceptingInput = true
  def setInput(input:Input):Unit = {} 
  def inputEnded:Unit = {}
  def inputStarted:Unit = {}
  
}

object Control {
  
  object Key extends Enumeration {
    type Key = Value
    val MOVE_LEFT, MOVE_RIGHT, MOVE_UP, MOVE_DOWN, JUMP, ACTION_1, ACTION_2, ACTION_3, ACTION_4, 
    ACTION_5, ACTION_6, ACTION_7, ACTION_8, ACTION_9 = Value
  }
  
  val keyMap = HashMap(
      0 -> Key.MOVE_LEFT  -> Input.KEY_A,
      0 -> Key.MOVE_RIGHT -> Input.KEY_D,
      0 -> Key.MOVE_DOWN  -> Input.KEY_S,
      0 -> Key.MOVE_UP 	  -> Input.KEY_W,
      0 -> Key.JUMP       -> Input.KEY_SPACE
  )
}