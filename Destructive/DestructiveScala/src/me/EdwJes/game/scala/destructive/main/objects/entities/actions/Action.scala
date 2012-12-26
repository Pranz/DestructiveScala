package me.EdwJes.game.scala.destructive.main.objects.entities.actions

import me.EdwJes.game.scala.destructive.main.objects.Alarm

abstract class Action {
  
  val delay:Int
  val duration:Int
  
  def preAction:Unit
  def action:Unit
  def then:Unit
  
  final def execute {
    preAction
    new Alarm(delay,() => {
      action
      new Alarm(duration, () => then)
    })
  }

}