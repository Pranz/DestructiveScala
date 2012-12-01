package me.EdwJes.game.scala.destructive.main

import me.EdwJes.game.scala.destructive.main.objects.{GameObject, Renderable}
import org.newdawn.slick.{Graphics, AppGameContainer, Input}


object Main {
  
  val TITLE = "DESTRUCTIVE"
  val TILE_SIZE = 16
  var input:Input = null
  
  val WIDHT  = 1024
  val HEIGHT = 756
  

  def main(args: Array[String]) {
    val container = createAppGameContainer()
    container start

  }
  
  def createAppGameContainer() : AppGameContainer = {
		val
		app = new AppGameContainer(new DestructiveGame(), 1024, 756, false);
		app.setUpdateOnlyWhenVisible(false);
		app.setTitle(TITLE);
		app.setShowFPS(false);
		app.setTargetFrameRate(60);
		return app;
	}
  
  object Camera extends Vector(0,0)

}