package com.calvin.fpinscala

object Main {
  import Chapter3.List._
  def main(args: Array[String]) = {
    val list: Chapter3.List[Int] = Chapter3.List(1,2,3,4,5)
    val listD: Chapter3.List[Double] = Chapter3.List(1,2,3,4,5)
    println(Chapter3.List.tail(list))
    println(Chapter3.List.setHead(list, 6))
    println(Chapter3.List.drop(list, 2))
    println(Chapter3.List.length(list))
    println(Chapter3.List.sumFoldLeft(list))
    println(Chapter3.List.productFoldLeft(listD))
    println(Chapter3.List.reverse(list))
    println(Chapter3.List.appendViaFoldLeft(list, Chapter3.List(6)))
    println(Chapter3.List.addInteger(list))
    println(Chapter3.List.toString(listD))
  }
}
