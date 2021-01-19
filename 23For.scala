// for ( sequence ) yield expression

val forRes = for (x <- List(1,2); y <- List("one", "two")) yield (x,y)
println(forRes)

