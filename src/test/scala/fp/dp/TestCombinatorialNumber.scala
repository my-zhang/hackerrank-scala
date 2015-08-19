package fp.dp

import org.junit.Test

/**
 * Created by mzhang on 8/15/15.
 */
class TestCombinatorialNumber {
  @Test
  def testSolve(): Unit = {
    assert(10 == CombinatorialNumber.solve(5, 3))
  }
}
