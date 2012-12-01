package me.EdwJes.game.scala.destructive.main.objects

import me.EdwJes.game.scala.destructive.main.Main

abstract class GameObject {
  
	(GameObject list) += this
	
	def destroy{
	  (GameObject list) -= this
	}
	
	def update:Unit
}

object GameObject{
  val list: scala.collection.mutable.ArrayBuffer[GameObject] = scala.collection.mutable.ArrayBuffer()
}