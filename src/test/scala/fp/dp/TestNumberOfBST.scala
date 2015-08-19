package fp.dp

import org.junit.Test

/**
 * Created by mzhang on 8/15/15.
 */
class TestNumberOfBST {
  @Test
  def testNumberOfBST: Unit = {
    assert(14 == NumberOfBST.solve(4))
    assert(25666077 == NumberOfBST.solve(100))
  }

}
