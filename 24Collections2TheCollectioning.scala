val xs = List.range(0,5)
println(xs)

val group = xs grouped 3
println(group.next())
println(group.next())

val slide = xs sliding 3
println(slide.next())
println(slide.next())
println(slide.next())

println(xs reduceLeft (_ + _))

import scala.collection.mutable.ListBuffer

var buf = ListBuffer[Int]()
println(buf)
buf += 10
buf appendAll xs
buf prepend -1
buf prependAll List.range(-5,0)
println(buf)
buf remove buf.length - 1
println(buf)
buf.padToInPlace(xs.length,0)
buf.patchInPlace(1, xs, xs.length - 1)
println(buf)

// This chapter is an exhaustive list of every function you can apply to any collection
// Good to have in front of you if you're working with collections