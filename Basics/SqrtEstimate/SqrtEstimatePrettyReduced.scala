import math._

object SqrtEstimate {
	def main(args: Array[String]): Unit = {
		println("sqrt(2)=" + sqrt(2))
	}	
	def sqrt(x: Double): Double =  {
		def sqrtIter(guess: Double): Double = {
			if(isGoodEnough(guess)){
				guess	    	
				} else{
					sqrtIter(improve(guess))
				} 
			}
			def isGoodEnough( guess: Double) = {
				math.abs(guess*guess-x)/x < 0.001
			}
			def improve(guess: Double) = {
				(guess + (x/guess)) / 2
		}
		sqrtIter(1.0)
	} 
}

