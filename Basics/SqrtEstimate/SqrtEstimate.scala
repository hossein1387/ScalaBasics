import math._

object SqrtEstimate {
	def main(args: Array[String]): Unit = {
		println("sqrt(2)=" + sqrt(2))
	}	

	def sqrtIter(guess: Double, x: Double): Double = {
	    if(isGoodEnough(guess, x)){
	        guess	    	
	    } else{
            sqrtIter(improve(guess, x), x)
	    } 
	}

	def isGoodEnough( guess: Double, x: Double) = {
		math.abs(guess*guess-x)/x < 0.001
	}

	def improve(guess: Double, x: Double) = {
		(guess + (x/guess)) / 2
	}

	def sqrt(x: Double) = sqrtIter(1.0, x)
}