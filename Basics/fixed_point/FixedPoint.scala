import math._

object FixedPoint {
	def main(args: Array[String]): Unit = {
		println("fixed point of 1+x/2 is: "+fixedPoint(x=>1+x/2)(1))
		println("sqrt(2)="+sqrt(2))
	}	
	val tolerance = 0.0001

	def isCloseEnough(x: Double, y: Double) = math.abs((x-y)/x) / x < tolerance

	def fixedPoint(f: Double=>Double)(firstGuess: Double) = {
		def iterate(guess: Double): Double = {
			val next = f(guess)
			if(isCloseEnough(guess, next)) next
			else iterate(next)
		}
		iterate(firstGuess)
	}	

	def averageDamp(f: Double=>Double)(x:Double) = (x+f(x))/2

	def sqrt(x: Double): Double = fixedPoint(averageDamp(y=>x/y))(1)
}


