package fp.recur

/**
 * Created by mzhang on 8/17/15.
 */
object ComputingGCD {
  def gcd(x: Int, y: Int): Int = {
    if (y == 0)
      x
    else
      gcd(y, x % y)

  }
}
