
object ImmutableLinkedList {
	def main(args: Array[String]): Unit = {
		val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
		println("nth(-1,list)="+nth(-1,list) )
	}	

	// Functions can have type parameters too:
	// ex: singleton[Boolean](true) ----> compiler can infer the type:
	// singleton[Boolean](true) == singleton(true)
	def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

	// Write a funciton nth that takes an integer n and a list and selects
	// the n'th element of the list. Elements are numbered from 0. If index
	// is outside of the range (from 0 up to the length of the list minus one),
	// a IndexOutOfBoundsException should be thrown:

	def nth[T](n: Int, xs: List[T]): T = {
		if (xs.isEmpty) throw new IndexOutOfBoundsException
		else if(n==0) xs.head
		else nth(n-1, xs.tail) 
	} 
}
 // Linked list is constructed from two building block:
 // 1- Nil: The empty list
 // 2- Cons: A cell containing an element and the remainder of the list

trait List[T] {
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
	
}

class Cons[T](val head: T, val tail: List[T]) extends List[T]{
	def isEmpty = false
}

class Nil[T] extends List[T]{
	def isEmpty: Boolean = true
	def head: Nothing = throw new NoSuchElementException("Nil.head")
	def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}



