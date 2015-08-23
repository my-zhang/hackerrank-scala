package fp.adhoc

/**
 * Created by mzhang on 8/22/15.
 * https://www.hackerrank.com/challenges/missing-numbers-fp
 */
object MissingNumbers {
  def main(args: Array[String]) {
    val n = readInt
    val A = readLine.split(" ").map(_.toInt).groupBy(identity)
    val m = readInt
    val B = readLine.split(" ").map(_.toInt).groupBy(identity)

    for ((k, g) <- B.toList.sortBy(_._1)) {
      if (!A.contains(k) | A(k).length < g.length) {
        print(s"$k ")
      }
    }
    println()
  }
}
