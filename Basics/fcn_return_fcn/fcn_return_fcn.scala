import math._

object FcnRetFcn {
	def main(args: Array[String]): Unit = {
		println("sum(cube(3))= " + sum(cube)(1,3))
	}	

	def sum(f: Double => Double): (Double, Double)=>Double = {
		def sumF(a: Double, b: Double): Double = {
			if(a>b) 0
			else f(a) + sumF(a+1, b)			
		}
		sumF
	}

    def sum_fcn(f: Double=>Double)(a: Double, b:Double): Double = if (a>b) 0 else f(a) + sum(f)(a+1,b)

    def cube(x: Double): Double = x*x*x
}

