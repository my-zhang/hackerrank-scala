package algo.dp

/**
 * Created by mzhang on 8/17/15.
 */
object FibonacciModified {
  val N = 21
  val (a, b) = (0, 1)
  val memo = Array.fill(N)(None: Option[BigInt])

  def fib(n: Int): BigInt = n match {
      case 1 => a
      case 2 => b
      case _ =>
        memo(n) match {
          case Some(nthFib) => nthFib
          case None =>
            val nthFib = fib(n-1) * fib(n-1) + fib(n-2)
            memo(n) = Some(nthFib)
            nthFib
        }
  }
}
