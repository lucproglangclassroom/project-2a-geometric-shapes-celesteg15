package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object TestFixtures:

  val simpleEllipse   = Ellipse(50, 30)
  val simpleRectangle = Rectangle(80, 120)

  val simpleLocation  = Location(70, 30, Rectangle(80, 120))

  // To get (-50, -30, 120, 70): shift the 20x40 rectangle right by 50
  // located rect bbox: (50,0) .. (70,40)  -> union maxX = 70, maxY = 40
  
  val basicGroup = Group(List(
    Ellipse(50, 30),
    Location(30, 0, Rectangle(20, 40))  // x = 30 (not 50)
  ))


  val simpleGroup = Group(List(
    Location(200, 100, Ellipse(50, 30)),
    Location(400, 300, Rectangle(100, 50))
  ))

 

  private val deepCluster: Shape =
    Group(List(
      Rectangle(50, 30),
      Rectangle(300, 60),
      Location(100, 200, Ellipse(50, 30))
    ))

  private val innerGroup: Shape =
    Group(List(
      Ellipse(20, 40),
      Location(150, 50, deepCluster)
    ))

  val complexGroup: Shape =
    Group(List(
      Location(50, 100, innerGroup)
    ))
  

end TestFixtures
