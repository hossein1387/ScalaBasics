import math._

object product_curry {
	def main(args: Array[String]): Unit = {
		if(!args.isEmpty){			
			val inputVal = args(0).toInt
			println("factorial($inputVal)="+factorial(inputVal))
		}else{
			println("Sorry! Please provide an integer!")
		}  
	}	

	//def product(f: Int => Int)(a: Int, b: Int): Int = if (a>b) 1 else f(a) * product(f)(a+1,b)

	def factorial(x: Int): Int = product(x=>x)(1,x) 

	def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:Int): Int =
	    if (a>b) zero
	    else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

	def product(f: Int=>Int)(a: Int, b:Int): Int = mapReduce(f, (x,y)=>x*y, 1)(a,b)
}


