package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) | Group([Shape])*/
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Ellipse(rx: Int, ry: Int)
  case Group(children: List[Shape])
  // TODO add missing cases (see test fixtures)


object Shape:
  object Rectangle:
    def apply(width: Int, height: Int): Shape.Rectangle =
      require(width  > 0 && height > 0, s"Rectangle requires positive width/height; got $width x $height")
      new Shape.Rectangle(width, height)

  object Ellipse:
    def apply(rx: Int, ry: Int): Shape.Ellipse =
      require(rx > 0 && ry > 0, s"Ellipse requires positive radii; got rx=$rx ry=$ry")
      new Shape.Ellipse(rx, ry)

  object Group:
    def apply(children: List[Shape]): Shape.Group =
      require(children.nonEmpty, "Group requires at least one child")
      new Shape.Group(children)