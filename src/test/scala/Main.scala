package edu.luc.cs.laufer.cs371.shapes

import TestFixtures.*
import Shape.Rectangle

object Main:
  def main(args: Array[String]): Unit =
    val bb = boundingBox(simplelocation)          
    println(s"bbox(simplelocation) = $bb")

    println(Rectangle(2, 3) == Rectangle(2, 3))

    bb.shape match
      case Rectangle(w, h) => println(s"width=$w height=$h")
      case other           => println(s"unexpected shape in bbox: $other")
      
end Main
