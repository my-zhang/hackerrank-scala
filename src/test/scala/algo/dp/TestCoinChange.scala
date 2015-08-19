package algo.dp

import org.junit.Test

/**
 * Created by mzhang on 8/18/15.
 */
class TestCoinChange {
  @Test
  def testSolve(): Unit = {
    assert(15685693751L == CoinChange.solve(24, 250, Array(41, 34, 46, 9,
      37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11)))
  }
}
