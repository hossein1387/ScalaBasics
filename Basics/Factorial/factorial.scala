import math._

object Factorial {
	def main(args: Array[String]): Unit = {
		println("factorial(5)=" + factorial(5))
	}	
	def factorial(x: Double): Double =  {
		if(x==0) 1 else x * factorial(x-1)
	}
}

