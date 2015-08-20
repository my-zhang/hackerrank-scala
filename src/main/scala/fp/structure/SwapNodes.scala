package fp.structure

/**
 * Created by mzhang on 8/20/15.
 * https://www.hackerrank.com/challenges/swap-nodes
 */
object SwapNodes {
  def solve(): Unit = {
    val n = readInt
    val tree = Array.fill(n+1)((0, 0))
    val root = 1

    for (i <- 1 to n) {
      val Array(l, r) = readLine.split(" ").map(_.toInt)
      tree(i) = (l, r)
    }
    val levelMap = Array.fill(n+1)(Array[Int]())
    dfsLevel(tree, root, 1, levelMap)

    val T = readInt

    for (t <- 1 to T) {
      val h = readInt
      for (i <- h to n by h) {
        for (node <- levelMap(i)) {
          tree(node) = tree(node).swap
        }
      }
      inOrder(tree, root)
      println()
    }
  }

  def dfsLevel(tree: Array[(Int, Int)], root: Int, h: Int, levelMap: Array[Array[Int]]): Unit = {
    if (root > 0) {
      levelMap(h) = levelMap(h) :+ root
      dfsLevel(tree, tree(root)._1, h+1, levelMap)
      dfsLevel(tree, tree(root)._2, h+1, levelMap)
    }
  }

  def inOrder(tree: Array[(Int, Int)], root: Int): Unit = {
    if (root > 0) {
      inOrder(tree, tree(root)._1)
      print(s"$root ")
      inOrder(tree, tree(root)._2)
    }
  }
}
