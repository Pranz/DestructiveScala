package me.EdwJes.game.scala.destructive.main

import org.newdawn.slick.geom.{Circle, Rectangle}
import org.newdawn.slick.{Game, GameContainer, Graphics, Color, Input}
import me.EdwJes.game.scala.destructive.main.objects.{
  GameObject, Renderable, Alarm, TestObject, Interactive, DefaultPhysical, Physical}
import me.EdwJes.game.scala.destructive.main.input.{EntityControl, BlockController}
import me.EdwJes.game.scala.destructive.main.objects.entities.{Entity, Humanoid}
import me.EdwJes.game.scala.destructive.main.objects.terrain.{TriangleBlock,
  Block, PhysicalBlock, VerticalScrollingBlock}

class DestructiveGame extends Game {
  
  implicit def extractPhysicalOption(option:Option[Physical]):Physical = option match {
    case Some(obj) => obj
    case None      => DefaultPhysical
  }
  
  var obj:Entity = null
  var initiated = false
  
  override def closeRequested = true
  override def getTitle = Main TITLE
  
  def debugList:List[String] = {
      //if (!initiated) List("")
      List(
    		  "x: "       + obj.position.x,
              "y: "       + obj.position.y,
              "dx: "	  + obj.deltaPosition.x,
              "dy: "      + obj.deltaPosition.y,
              "hsp: "	  + obj.hspeed,
              "vsp: "     + obj.vspeed,
              "velocity " + obj.velocity,
              "relative x"+ obj.prvRelativeObject.movement.x,
              "relative y"+ obj.prvRelativeObject.movement.y
      )
  }

  override def init(container:GameContainer) {
    Main.input = container.getInput
    new BlockController(0,0)
    new Block(Vector(100, 500), 50, 2)
    new TriangleBlock(Vector(300,500), 20, -20)
    new Block(Vector(600, 200), 2, 50)
    new PhysicalBlock(Vector(360, 450), 6, 2)
    new VerticalScrollingBlock(Vector(280, 600), 500, 0)
    new VerticalScrollingBlock(Vector(460, 450), 200, 0, len = 16)
    obj = new Humanoid(Vector(100, 250))
    new EntityControl(obj, 0)
    initiated = true
  }
  
  override def render(container:GameContainer, g:Graphics) {
    g.translate(-Main.Camera.x,-Main.Camera.y)
      (Renderable list) foreach (_.draw(g))
    g.translate( Main.Camera.x, Main.Camera.y)
    drawList(("fps: " + container.getFPS)::debugList, g)
  }
  
  override def update(container:GameContainer, delta : Int) {
    (Interactive list) foreach {(o) => o.previousPosition = o.position}
    (GameObject list).clone foreach (_ update)
    Main.Camera.x -= 0
  }
  
  def drawList(list:List[String], g:Graphics) {
    for (i <- 0 to list.size - 1){
      g.drawString(list(i), 0, 16*i)
    }
  }
  
  
  
}