package algo.dp

import org.junit.Test

/**
 * Created by mzhang on 8/17/15.
 */
class TestFibonacciModified {
  @Test
  def testFib(): Unit = {
    assert(BigInt("84266613096281243382112") == FibonacciModified.fib(10))
  }
}
