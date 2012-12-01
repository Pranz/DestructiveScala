package me.EdwJes.game.scala.destructive.main.objects
import org.newdawn.slick.Graphics

trait Renderable extends GameObject {
  (Renderable list) += this
  
  def draw(g:Graphics):Unit
  
  override def destroy{
    (Renderable list) -= this
    super.destroy
  }

}

object Renderable {
  val list: collection.mutable.ArrayBuffer[Renderable] = collection.mutable.ArrayBuffer()
}