import math._

object Factorial {
	def main(args: Array[String]): Unit = {
		if(!args.isEmpty){			
			println(args(0))
			val factNum = args(0).toDouble
			println(factNum)
			println("factorial($factNum)="+factorial(factNum))
			println("sumFactorial($factNum)="+sumFactorials(0,factNum))
		}else{
			println("Sorry! Please provide an integer!")
		}  
	}	

	def sum(f: Double => Double, a: Double, b: Double): Double = {
		if(a > b) 0
		else f(a) + sum(f, a+1, b)
	}

	def factorial(x: Double ): Double =  {
		def factorialUpdate(x: Double, update: Double): Double = if(x==0) update else factorialUpdate(x-1, update*x)	
		factorialUpdate(x,1)	
	}

	def sumFactorials(a: Double, b:Double) = sum(factorial, a, b)

}

