object class_hierarchies {
	def main(args: Array[String]): Unit = {
	}	
}

// Write a method uninion for forming the uninion of two sets. You should
// implement the following abstract class:

abstract class IntSet {
	def incl(x: Int ): IntSet // include element into the set
	def contains(x: Int): Boolean // checks if the element is in the set`
	def uninion(other: IntSet): IntSet
}

// Since Empty is same in all branches of the tree, we can use object
// instead of class to force scala only use one instance of it. This
// defines a singleton object named Empty:
object Empty extends IntSet {
	def incl(x: Int ): IntSet = new NonEmpty(x, Empty, Empty)
	def contains(x: Int): Boolean = false	
	def uninion(other: IntSet): IntSet = other
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
		if (x < elem) left contains x // == left.contains(x)
		else if (x > elem) right contains x
		else true		
	}

	def incl(x: Int): IntSet = {
		if (x < elem) new NonEmpty(elem, left incl x, right)
		else if (x > elem) new NonEmpty(elem, left, right incl x)
		else this
	}
	override def toString = "{" + left + elem + right + "}"

	def uninion(other: IntSet): IntSet = {
         (left uninion right) uninion
		//(left.uninion(right).uninion(other)).incl(elem)
	}
}
