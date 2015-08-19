package fp.intro

import org.junit.Test

/**
 * Created by mzhang on 8/15/15.
 */
class TestOddElementSum {
  @Test
  def testSolve(): Unit = {
    // Sum of odd elements = 3 + 5 + 7 + 1 = 16
    assert(16 == OddElementSum.solve(List(3, 2, 4, 6, 5, 7, 8, 0, 1)))
  }
}
