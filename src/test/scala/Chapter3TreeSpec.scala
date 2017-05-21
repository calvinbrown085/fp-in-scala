package com.calvin.fpinscala

import org.specs2.mutable.Specification
import org.specs2.specification.Scope


class Chapter3TreeSpec extends Specification {
  //import Chapter3Tree.Tree._
  "size should computer the size of a Tree" >> {
    val tree: Chapter3Tree.Tree[Int] = Chapter3Tree.Tree(1,2,3,4)
    size(tree) == 4
  }

}
