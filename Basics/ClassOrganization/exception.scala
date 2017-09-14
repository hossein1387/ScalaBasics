
object exception_example {
	def main(args: Array[String]): Unit = {
	}	

	def error(msg: String) = throw new Error(msg)

	error("shit went wrong!")
}

