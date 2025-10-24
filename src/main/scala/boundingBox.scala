package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = 
   // (minX, minY, maxX, maxY)
    def bbox(sh: Shape): (Int, Int, Int, Int) = sh match
      case Rectangle(w, h) =>
        (0, 0, w, h)

      case Ellipse(rx, ry) =>
        (-rx, -ry, rx, ry)

      case Location(x, y, inner) =>
        val (minX, minY, maxX, maxY) = bbox(inner)
        (minX + x, minY + y, maxX + x, maxY + y)


      case Group(children) =>

        children
          .map(bbox)
          .reduceLeft { case ((aMinX, aMinY, aMaxX, aMaxY), (bMinX, bMinY, bMaxX, bMaxY)) =>
            (
              math.min(aMinX, bMinX),
              math.min(aMinY, bMinY),
              math.max(aMaxX, bMaxX),
              math.max(aMaxY, bMaxY)
            )
        }

    val (minX, minY, maxX, maxY) = bbox(s)
    Location(minX, minY, Rectangle(maxX - minX, maxY - minY))


end boundingBox
