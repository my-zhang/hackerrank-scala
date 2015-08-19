package fp.intro

import org.junit.Test

/**
 * Created by mzhang on 8/15/15.
 */
class TestEvaluateEPowX {
  @Test
  def testSolve(): Unit = {
    assert((143.6895 - EvaluateEPowX.solve(5.0f)).abs < 0.1)
  }
}
