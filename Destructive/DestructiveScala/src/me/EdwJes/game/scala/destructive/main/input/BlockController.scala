package me.EdwJes.game.scala.destructive.main.input

import me.EdwJes.game.scala.destructive.main.Main
import me.EdwJes.game.scala.destructive.main.objects.terrain.ControllableBlock

import org.newdawn.slick.{Input, MouseListener}

class BlockController(playerID:Int, val blockID:Int) extends Control(playerID) with MouseListener {
  
  Main.input.addMouseListener(this)

  def handleKeys(input: Input): Unit = {}
  def keyPressed(arg0: Int, arg1: Char): Unit = {}
  def keyReleased(arg0: Int, arg1: Char): Unit = {}
  
  def mouseClicked(button:Int, x:Int, y:Int, clickCount:Int) {}
  def mouseDragged(oldx:Int, oldy:Int, newx:Int, newy:Int) {}
  def mouseMoved(oldx:Int, oldy:Int, newx:Int, newy:Int) {}
  def mousePressed(button:Int, x:Int, y:Int) {}
  def mouseReleased(button:Int, x:Int, y:Int) {}
  def mouseWheelMoved(delta:Int) {
    (ControllableBlock list).filter(_.blockID == blockID) foreach {_(0) + delta}
  }

}