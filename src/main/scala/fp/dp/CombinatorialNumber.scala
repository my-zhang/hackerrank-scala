package fp.dp

/**
 * Created by mzhang on 8/15/15.
 */
object CombinatorialNumber {
  val N = 1000
  val M = 100000007L
  val memo = Array.fill(N+1, N+1)(0L)

  def solve(n: Int, k: Int): Long = {
    if (n == k | k == 0) 1
    else {
      if (memo(k)(n) == 0) {
        memo(k)(n) = (solve(n-1, k) + solve(n-1, k-1)) % M
      }
      memo(k)(n)
    }
  }
}
