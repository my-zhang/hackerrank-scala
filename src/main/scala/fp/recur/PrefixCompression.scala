package fp.recur

import scala.annotation.tailrec

/**
 * Created by mzhang on 8/22/15.
 * https://www.hackerrank.com/challenges/prefix-compression
 */
object PrefixCompression {
  def main(args: Array[String]) {
    val a = readLine
    val b = readLine
    val prefix = commonPrefix(a, b)
    val suffixA = a.drop(prefix.length)
    val suffixB = b.drop(prefix.length)

    println(s"${prefix.length} $prefix")
    println(s"${suffixA.length} $suffixA")
    println(s"${suffixB.length} $suffixB")

  }

  def commonPrefix(a: String, b: String): String = {
    @tailrec def loop(x: List[Char], y: List[Char], pre: List[Char]): List[Char] = (x, y) match {
      case (Nil, _) | (_, Nil) => pre.reverse
      case (hx::tx, hy::ty) if hx != hy => pre.reverse
      case (hx::tx, hy::ty) => loop(tx, ty, hx :: pre)
    }
    loop(a.toList, b.toList, List[Char]()).mkString("")
  }
}
