package fp.intro

/**
 * Created by mzhang on 8/15/15.
 * e^x = 1 + x + x^2/2! + x^3/3! + x^4/4! + ...
 * Use the above expansion for the first 10 terms.
 */

object EvaluateEPowX {
  def solve(x: Float): Float = {
    def nthTerm(x: Float, n: Int): Float = {
      if (n == 1) 1
      else x * nthTerm(x, (n-1)) / (n-1)
    }

    (1 to 10).map(i => nthTerm(x, i)).sum
  }
}
