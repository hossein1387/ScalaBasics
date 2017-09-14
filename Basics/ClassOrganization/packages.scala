package week3

import math._


object RationalObj {
	def main(args: Array[String]): Unit = {
		val r = new Rational(1,2)
		val s = new Rational(2,3)
		val sum = r+s
		val sub = r-s
		val negr= -r
		println(r.toString+"+"+s.toString+"="+sum.toString)
		println(r.toString+"-"+s.toString+"="+sub.toString)
		println("-r="+negr.toString)
	}	
}


class Rational(x: Int, y:Int) {
	require(y !=0, "denominator must be nonzero") // ---> require is used to enforce a precondition on the caller of a function
	assert(y!=0) // assert is used as to check the code of the function itself

// Private Members:
    private val g = gcd(x,y)
    private def gcd(a:Int, b: Int): Int = if(b==0) a else gcd(b,a%b) 

// Public Members:

    def this(x: Int) = this(x,1) // second constructor of the class Rational (first one was primary)

	//def numer = x/g
	//def denom = y/g
	//def numer = x/gcd(x,y) --> if numer and denom are called infrequently
	//def denom = y/gcd(x,y) --> if numer and denom are called infrequently
    val numer = x/gcd(x,y) //--> if numer and denom are called frequently   
    val denom = y/gcd(x,y) //--> if numer and denom are called frequently   

	def add(that:Rational): Rational =
		new Rational(
			this.numer*that.denom + this.denom*that.numer, 
			this.denom*that.denom
			)
	def neg: Rational = new Rational(-this.numer, this.denom)

	def sub(that: Rational) = add(that.neg)

	def less(that: Rational) = this.numer*that.denom < that.numer*this.denom

	def max(that: Rational) = if (this.less(that)) that else this

	override def toString = this.numer+"/"+this.denom

// Operators:
	def <(that: Rational) = this.numer*that.denom < that.numer*this.denom
	def +(that:Rational): Rational =
		new Rational(
			this.numer*that.denom + this.denom*that.numer, 
			this.denom*that.denom
			)
	def -(that: Rational) = this + -that

	def unary_- : Rational = new Rational(-this.numer, this.denom)

}
