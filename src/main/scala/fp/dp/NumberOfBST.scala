package fp.dp

/**
 * Created by mzhang on 8/15/15.
 */
object NumberOfBST {
  val N = 1000
  val M = 100000007L
  val memo = Array.fill(N+1)(0L)

  def solve(n: Int): Long = {
    if (n <= 1) 1
    else {
      if (memo(n) == 0) {
        memo(n) = (0 until n).map(left => (solve(left) * solve(n-1-left)) % M).sum % M
      }
      memo(n)
    }
  }
}
