object main	{
	def main(args: Array[String]): Unit = {
		callByValue(doSomeThing())
		callByName(doSomeThing())
	}

	def doSomeThing() = {
		println("calling doSomeThing!")
		1
	}

	def callByName(x: => Int) = {
		println("\n")
		println("calling callByName")
		println("x1=" + x)
		println("x2=" + x)
	}

	def callByValue(x: Int) = {
		println("\n")
		println("calling callByValue")
		println("x1=" + x)
		println("x2=" + x)
	}	
}