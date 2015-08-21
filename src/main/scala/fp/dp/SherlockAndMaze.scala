package fp.dp

/**
 * Created by mzhang on 8/20/15.
 * https://www.hackerrank.com/challenges/sherlock-and-the-maze
 */
object SherlockAndMaze {
  def main(args: Array[String]) {
    val N = 101
    val dp = solve(N, N, N)

    val T = readInt
    for (t <- 1 to T) {
      val Array(r, c, k) = readLine.split(" ").map(_.toInt)

      if ((r, c) == (1, 1))
        println(1)
      else
        println(dp(r)(c).slice(0, k+1).map(_.sum).sum % M)
    }
  }

  val M = 1000000007L

  def solve(n: Int, m: Int, k: Int): Array[Array[Array[Array[Long]]]] = {
    val dp = Array.fill(n+1, m+1, k+1, 2)(0L)

    for (c <- 1 to m) {
      dp(1)(c)(0)(0) = 1L
    }

    for (r <- 1 to n) {
      dp(r)(1)(0)(1) = 1L
    }

    for (r <- 2 to n) {
      for (c <- 2 to m) {
        for (t <- 0 to k) {
          dp(r)(c)(t)(0) = dp(r)(c-1)(t)(0) + (if (t > 0) dp(r)(c-1)(t-1)(1) else 0L)
          dp(r)(c)(t)(1) = dp(r-1)(c)(t)(1) + (if (t > 0) dp(r-1)(c)(t-1)(0) else 0L)

          dp(r)(c)(t)(0) %= M
          dp(r)(c)(t)(1) %= M
        }
      }
    }

    dp
  }
}
