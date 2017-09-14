import scala.collection.mutable.HashMap
val vars = new HashMap[String, Int]()
vars("a") = 1
vars("b") = 2
println(vars.size)
println(vars.contains("c"))
vars.getOrElse("c", -1)
vars.keys
vars.values
