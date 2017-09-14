// A trait is declared like an abstract class, just use trait instead of 
// abstract class.
// Classes, objects and traits can inherit from at most one class but 
// arbitrary many traits:
// Ex: class Square extends Shape with Planner with Movable ... 
// Traits cannot have parameters and only classes can

object trait_example {
	def main(args: Array[String]): Unit = {
	}	
}


trait Planner {
	def height  : Int
	def width   : Int
	def surface = height * width
	
}