package fp.adhoc

/**
 * Created by mzhang on 8/22/15.
 * https://www.hackerrank.com/challenges/common-divisors
 */
object CommonDivisors {
  def gcd(a: Int, b: Int): Int = {
    if (b == 0)
      a
    else
      gcd(b, a % b)
  }

  def countDivisors(a: Int): Int = {
    val lst = for (i <- 1 to math.sqrt(a).toInt; if (a % i == 0)) yield {
      if (i * i == a)
        1
      else
        2
    }
    lst.sum
  }

  def main(args: Array[String]) {
    val T = readInt
    for (t <- 1 to T) {
      val Array(a, b) = readLine.split(" ").map(_.toInt)
      val d = gcd(a, b)
      println(countDivisors(d))
    }
  }
}
