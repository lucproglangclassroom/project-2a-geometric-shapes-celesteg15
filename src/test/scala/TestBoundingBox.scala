package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestBoundingBox extends AnyFunSuite:

  private def check(desc: String, s: Shape, x: Int, y: Int, w: Int, h: Int): Unit =
    test(desc):
      val Location(bx, by, Rectangle(bw, bh)) = (boundingBox(s)): @unchecked
      assert(bx == x)
      assert(by == y)
      assert(bw == w)
      assert(bh == h)

  // enable tests
  check("simple ellipse",   simpleEllipse,   -50, -30, 100,  60)
  check("simple rectangle", simpleRectangle,   0,   0,  80, 120)
  check("simple location",  simpleLocation,   70,  30,  80, 120)
  check("basic group",      basicGroup,      -50, -30, 100,  70)
  check("simple group",     simpleGroup,     150,  70, 350, 280)
  check("complex group",    complexGroup,     30,  60, 470, 320)

end TestBoundingBox
