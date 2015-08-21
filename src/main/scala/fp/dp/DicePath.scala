package fp.dp

/**
 * Created by mzhang on 8/20/15.
 */
object DicePath {

  def main(args: Array[String]) {
    val dp = solve()
    val T = readInt
    for(t <- 1 to T) {
      val Array(r, c) = readLine.split(" ").map(_.toInt)
      println(dp(r)(c).flatten.reduce(_ max _))
    }
  }

  def rotateRight(u: Int, r: Int, f: Int): (Int, Int, Int) = (7-r, u, f)

  def rotateDown(u: Int, r: Int, f: Int): (Int, Int, Int) = (7-f, r, u)

  def calcValue(prevValue: Option[Int], pattern: (Int, Int, Int)): Option[Int] = prevValue match {
    case Some(v) => Some(v + pattern._1)
    case None => None
  }

  def solve(): Array[Array[Array[Option[Int]]]] = {
    val (m, n) = (60, 60)
    val patterns = Array[(Int, Int, Int)](
      (1, 4, 2), (1, 2, 3), (1, 3, 5), (1, 5, 4),
      (6, 2, 4), (6, 4, 5), (6, 5, 3), (6, 3, 2),
      (2, 1, 4), (2, 4, 6), (2, 6, 3), (2, 3, 1),
      (5, 4, 1), (5, 1, 3), (5, 3, 6), (5, 6, 4),
      (4, 2, 1), (4, 1, 5), (4, 5, 6), (4, 6, 2),
      (3, 1, 2), (3, 2, 6), (3, 6, 5), (3, 5, 1))

    val k = patterns.length
    val dp = Array.fill[Option[Int]](m+1, n+1, k)(None)

    dp(1)(1)(0) = Some(1)

    for (c <- 2 to n) {
      for (i <- 0 until k) {
        val next = patterns.indexOf((rotateRight _).tupled(patterns(i)))
        dp(1)(c)(next) = calcValue(dp(1)(c-1)(i), patterns(next))
      }
    }

    for (r <- 2 to m) {
      for (i <- 0 until k) {
        val next = patterns.indexOf((rotateDown _).tupled(patterns(i)))
        dp(r)(1)(next) = calcValue(dp(r-1)(1)(i), patterns(next))
      }
    }

    for (r <- 2 to m) {
      for (c <- 2 to n) {
        for (i <- 0 until k) {
          val toRight = patterns.indexOf((rotateRight _).tupled(patterns(i)))
          val toDown = patterns.indexOf((rotateDown _).tupled(patterns(i)))

          dp(r)(c)(toRight) = List(dp(r)(c)(toRight), calcValue(dp(r)(c-1)(i), patterns(toRight))).flatten match {
            case Nil => None
            case lst => Some(lst.max)
          }
          dp(r)(c)(toDown) = List(dp(r)(c)(toDown), calcValue(dp(r-1)(c)(i), patterns(toDown))).flatten match {
            case Nil => None
            case lst => Some(lst.max)
          }
        }
      }
    }

    dp
  }
}
