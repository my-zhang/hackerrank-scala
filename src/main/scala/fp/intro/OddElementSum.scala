package fp.intro

/**
 * Created by mzhang on 8/15/15.
 */
object OddElementSum {
  def solve(arr:List[Int]):Int = arr.filter(x => x % 2 != 0).sum
}
