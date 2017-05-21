package com.calvin.fpinscala

object Chapter3 {
  sealed trait List[+A] // `List` data type, parameterized on a type, `A`
  case object Nil extends List[Nothing] // A `List` data constructor representing the empty list
  /* Another data constructor, representing nonempty lists. Note that `tail` is another `List[A]`,
  which may be `Nil` or another `Cons`.
   */
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List { // `List` companion object. Contains functions for creating and working with lists.
    def sum(ints: List[Int]): Int = ints match { // A function that uses pattern matching to add up a list of integers
      case Nil => 0 // The sum of the empty list is 0.
      case Cons(x,xs) => x + sum(xs) // The sum of a list starting with `x` is `x` plus the sum of the rest of the list.
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x,xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] = // Variadic function syntax
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

    val x = List(1,2,3,4,5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }

    def append[A](a1: List[A], a2: List[A]): List[A] =
      a1 match {
        case Nil => a2
        case Cons(h,t) => Cons(h, append(t, a2))
      }

    def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = // Utility functions
      as match {
        case Nil => z
        case Cons(x, xs) => f(x, foldRight(xs, z)(f))
      }
    def foldRightViaFoldLeft[A,B](l: List[A], z: B)(f: (A,B) => B): B =
      foldLeft(reverse(l), z)((b,a) => f(a,b))

    def sum2(ns: List[Int]) =
      foldRight(ns, 0)((x,y) => x + y)

    def product2(ns: List[Double]) =
      foldRight(ns, 1.0)(_ * _) // `_ * _` is more concise notation for `(x,y) => x * y`; see sidebar


    def tail[A](l: List[A]): List[A] = l match {
      case Nil => Nil
      case Cons(_, x) => x
    }

    def setHead[A](l: List[A], h: A): List[A] = l match {
      case Nil => sys.error("Can't set head on empty list")
      case Cons(a, b) => Cons(h, b)
    }

    def drop[A](l: List[A], n: Int): List[A] = {
      if(n <= 0) l
      else l match {
        case Nil => Nil
        case Cons(_, x) => drop(x, n -1)
      }
    }

    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
      case Cons(x, y) if(f(x)) => dropWhile(y, f)
      case _ => l
    }

    def init[A](l: List[A]): List[A] = l match {
      case Nil => Nil
      case Cons(_, Nil) => Nil
      case Cons(x, y) => Cons(x, init(y))
    }

    @annotation.tailrec
    def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B =
      l match {
        case Nil => z
        case Cons(a, b) => foldLeft(b, f(z, a))(f)
      }
    def concat[A](l: List[List[A]]): List[A] =
      foldRight(l, Nil:List[A])(append)

    def length[A](l: List[A]): Int =
      foldLeft(l, 0)((acc, _) => acc + 1)

    def sumFoldLeft(ns: List[Int]) =
      foldLeft(ns, 0)((x,y) => x + y)

    def productFoldLeft(ns: List[Double]) =
      foldRight(ns, 1.0)(_ * _) // `_ * _` is more concise notation for `(x,y) => x * y`; see sidebar

    def reverse[A](l: List[A]): List[A] =
      foldLeft(l, List[A]())((acc, h) => Cons(h, acc))

    def appendViaFoldLeft[A](l: List[A], r: List[A]): List[A] =
      foldLeft(reverse(l), r)((h , acc) => Cons(acc, h))

    def appendViaFoldRight[A](l: List[A], r: List[A]): List[A] =
      foldRight(l, r)(Cons(_, _))

    def map[A,B](l: List[A])(f: A => B): List[B] =
      foldRightViaFoldLeft(l, Nil:List[B])((h, t) => Cons(f(h), t))

    def addInteger(l: List[Int]): List[Int] = //exersize 3.16
      foldLeft(reverse(l), List[Int]())((h, acc) => Cons(acc + 1, h))

    def toString(l: List[Double]): List[String] = //exersize 3.17
      foldLeft(reverse(l), List[String]())((h, acc) => Cons(acc.toString, h))


    def filter[A](l: List[A])(f: A => Boolean): List[A] = //exersize 3.19
      foldRightViaFoldLeft(l, Nil:List[A])((h, t) => if(f(h)) Cons(h, t) else t)


    def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] =
      concat(map(as)(f))
  }


}
