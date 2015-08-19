package algo.dp

/**
 * Created by mzhang on 8/17/15.
 */
object CoinChange {
  def solve(n: Int, c: Int, W: Array[Int]): Long = {
    val dp = Array.fill(n+1, c+1)(0L)
    for (i <- 0 to n) dp(i)(0) = 1L

    for (i <- 1 to n) {
      for (j <- 1 to c) {
        if (j < W(i-1)) dp(i)(j) = dp(i-1)(j)
        else dp(i)(j) = dp(i)(j - W(i-1)) + dp(i-1)(j)
      }
    }
    dp(n)(c)
  }
}
