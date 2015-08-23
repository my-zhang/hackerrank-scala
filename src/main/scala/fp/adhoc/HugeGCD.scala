package fp.adhoc

/**
 * Created by mzhang on 8/22/15.
 */
object HugeGCD {
  def gcd(x: BigInt, y: BigInt): BigInt = {
    if (y == 0)
      x
    else
      gcd(y, x % y)
  }

  def main(args: Array[String]) {

    val n = readInt
    val A = readLine.split(" ").map { x => BigInt(x) }
    val m = readInt
    val B = readLine.split(" ").map { x => BigInt(x) }

    val a = A.reduceLeft[BigInt](_ * _)
    val b = B.reduceLeft[BigInt](_ * _)

    println(gcd(a, b) % 1000000007)
  }
}
