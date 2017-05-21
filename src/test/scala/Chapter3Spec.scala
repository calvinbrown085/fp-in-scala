package com.calvin.fpinscala

import org.specs2.mutable.Specification
import org.specs2.specification.Scope


class Chapter3Spec extends Specification {
  import Chapter3.List._

  "tail should return a list without it's head" >> { //Exercise 3.2
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    tail(list) === Chapter3.List(2,3,4,5)
  }

  "setHead should return a list with a different head" >> { //Exercise 3.3
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    setHead(list, 6) === Chapter3.List(6,2,3,4,5)
  }

  "drop should return a list without the first n" >> { //Exercise 3.4
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    drop(list, 3) === Chapter3.List(4,5)
  }

  "dropWhile should return a list without the first n as long as it specifies a predicate" >> { //Exercise 3.5
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    def f(x: Int) = if(x < 4) true else false
    dropWhile(list, f) === Chapter3.List(4,5)
  }

  "init should return a list of everything but the last element" >> { //Exercise 3.6
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    init(list) === Chapter3.List(1,2,3,4)
  }

  "length should return the length of a list" >> { //Exercise 3.9
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    Chapter3.List.length(list) === 5
  }

  "sumFoldLeft should return the sum of our list" >> { //Exercise 3.11 part 1
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    sumFoldLeft(list) === 15
  }

  "productFoldLeft should return the products of our list" >> { //Exercise 3.11 part 2
    val list: Chapter3.List[Double] = Chapter3.List(1,2,3,4,5)
    productFoldLeft(list) === 120.0
  }

  "reverse should return reverse of our list" >> { //Exercise 3.12
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    reverse(list) === Chapter3.List(5,4,3,2,1)
  }

  "append should append a list to our list" >> { //Exercise 3.15
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    val aList: Chapter3.List[Int] = Chapter3.List(6)
    appendViaFoldLeft(list, aList) === Chapter3.List(1,2,3,4,5,6)
  }

  "addInteger should append a list to our list" >> { //Exercise 3.16
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    addInteger(list) === Chapter3.List(2,3,4,5,6)
  }

  "toString should append a list to our list" >> { //Exercise 3.17
    val list: Chapter3.List[Double] = Chapter3.List(2,3,4,5,6)
    Chapter3.List.toString(list) === Chapter3.List("2.0","3.0","4.0","5.0","6.0")
  }

  "map should traverse our list and add 1" >> { //Exercise 3.18
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    def f(x: Int) = x + 1
    Chapter3.List.map(list)(f) === Chapter3.List(2,3,4,5,6)
  }

  "filter should traverse our list and remove odd numbers" >> { //Exercise 3.19
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5,6)
    def f(x: Int) = if(x % 2 == 0) true else false
    Chapter3.List.filter(list)(f) === Chapter3.List(2,4,6)
  }

  // "flatMap should traverse our list into 1 list" >> { //Exercise 3.20
  //   val list: Chapter3.List[Int] = Chapter3.List(1,2,3)
  //   def f(x: Int) = Chapter3.List(x)
  //   Chapter3.List.flatMap(list)(f) === Chapter3.List(1,1,2,2,3,3)
  // }








}
