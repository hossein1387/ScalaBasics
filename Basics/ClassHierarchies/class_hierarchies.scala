 import math._

object class_hierarchies {
	def main(args: Array[String]): Unit = {
		val t1 = new NonEmpty(3, new Empty, new Empty)
		println(t1.toString)
		println(t1.incl(4).toString)
	}	
}
// We want to create a binary tree. We have two types of trees:
// - A tree for the empty set
// - A tree consisting of an integer and two sub-trees
// 
//        7
//     /     \
//    5       12
//   / \     /  \
//  E   E   9    13
//        /  \   / \
//       E   E  E   E
// Since class is absract, no need to add body for 
// them. Consequently, we can not create a new object
// of a abstract class

abstract class IntSet {
	def incl(x: Int ): IntSet // include element into the set
	def contains(x: Int): Boolean // checks if the element is in the set`
}

// Since Empty is same in all branches of the tree, we can use object
// instead of class to force scala only use one instance of it. This
// defines a singleton object named Empty:
object Empty extends IntSet {
	def incl(x: Int ): IntSet = new NonEmpty(x, Empty, Empty)
	def contains(x: Int): Boolean = false	
	override def toString = "."
}
/*
class Empty extends IntSet {
	def incl(x: Int ): IntSet = new NonEmpty(x, new Empty, new Empty)
	def contains(x: Int): Boolean = false	
	override def toString = "."
}
*/
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet{
	def contains(x: Int): Boolean = {
		if (x < elem) left contains x
		else if (x > elem) right contains x
		else true		
	}

	def incl(x: Int): IntSet = {
		if (x < elem) new NonEmpty(elem, left incl x, right)
		else if (x > elem) new NonEmpty(elem, left, right incl x)
		else this
	}
	override def toString = "{" + left + elem + right + "}"
}
