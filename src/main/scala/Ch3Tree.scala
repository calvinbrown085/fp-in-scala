package com.calvin.fpinscala

object Chapter3Tree {
  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  object Tree {

    def size[A](t: Tree[A]): Int = t match {
      case Leaf(a) => 1
      case Branch(l, r) => size(l) + size(r)
    }
  }
}
