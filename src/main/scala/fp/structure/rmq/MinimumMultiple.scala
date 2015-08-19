package fp.structure.rmq

/**
 * Created by mzhang on 8/16/15.
 * https://www.hackerrank.com/challenges/minimum-multiple
 */
abstract class TreeNode

case class Node(l: Int, r: Int, value: BigInt, leftChild: TreeNode, rightChild: TreeNode) extends TreeNode
case class Leaf(l: Int, r: Int, value: BigInt) extends TreeNode

object MinimumMultiple {
  val M: BigInt = 1000000007

  def mid(l: Int, r: Int): Int = (l + r) / 2

  def gcd(a: BigInt, b: BigInt): BigInt = {
    if (b.equals(0)) a else gcd(b, a % b)
  }
  def lcm(a: BigInt, b: BigInt): BigInt = a * b / gcd(a, b)

  def buildTree(l: Int, r: Int, value: BigInt): TreeNode = {
    if (l != r)
      Node(l, r, value, buildTree(l, mid(l, r), value), buildTree(mid(l, r) + 1, r, value))
    else
      Leaf(l, r, value)
  }

  def f(a: BigInt, b: BigInt): BigInt = lcm(a, b)

  def update(rootNode: TreeNode, idx: Int, mul: Int): (TreeNode, BigInt) = {
    rootNode match {
      case Node(l, r, value, leftChild, rightChild) => {
        if (idx <= mid(l, r)) {
          val (updatedLeft, leftValue) = update(leftChild, idx, mul)
          (Node(l, r, f(value, leftValue), updatedLeft, rightChild), f(value, leftValue))
        }
        else {
          val (updatedRight, rightValue) = update(rightChild, idx, mul)
          (Node(l, r, f(value, rightValue), leftChild, updatedRight), f(value, rightValue))
        }
      }
      case Leaf(l, r, value) => (Leaf(l, r, value * mul), value * mul)
    }
  }

  def query(rootNode: TreeNode, i: Int, j: Int): BigInt = {
    rootNode match {
      case Node(l, r, value, leftChild, rightChild) => {
        if (l == i & j == r) value
        else if (j <= mid(l, r))
          query(leftChild, i, j)
        else if (i > mid(l, r))
          query(rightChild, i, j)
        else
          f(query(leftChild, i, mid(l, r)), query(rightChild, mid(l, r) + 1, j))
      }
      case Leaf(l, r, value) => value
    }
  }

  def initTree(rootNode: TreeNode, nums: Array[Int]): TreeNode = {
    var initializedTree = rootNode
    for ((value, idx) <- nums.zipWithIndex) {
      initializedTree = update(initializedTree, idx, value)._1
    }
    initializedTree
  }

  def doQueries(rootNode: TreeNode, t: Int): Unit = {
    if (t > 0) {
      val Array(cmd, a, b) = readLine.split(" ")
      if (cmd == "U") {
        val idx = a.toInt
        val mul = b.toInt
        doQueries(update(rootNode, idx, mul)._1, t-1)
      }
      else {
        val i = a.toInt
        val j = b.toInt
        println(query(rootNode, i, j) % M)
        doQueries(rootNode, t-1)
      }
    }
  }
}
