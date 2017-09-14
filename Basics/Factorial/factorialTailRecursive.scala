import math._

object Factorial {
	def main(args: Array[String]): Unit = {
		println("factorial(5)=" + factorial(5, 1))
		if (!args.isEmpty){
		    println("args are=" + args(0))
		}
	}	
	def factorial(x: Double, update: Double): Double =  {
		if(x==0) update else factorial(x-1, update*x)
	}
}

