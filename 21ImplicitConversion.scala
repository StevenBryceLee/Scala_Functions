implicit def doubleToInt(x: Double) = x.toInt
val i: Int = 3.5
println(i)

case class Rectangle(width: Int, height: Int)

implicit class RectangleMaker(width: Int) {
    def x(height: Int) = Rectangle(width, height)
}

val myRect = 3 x 4
println(myRect)

def maxListImpParm[T](elements: List[T])
    (implicit ordering: Ordering[T]): T = 
        elements match {
            case List() =>
                throw new IllegalArgumentException("Empty list")
            case List(x) => x
            case x :: rest => 
                val maxRest = maxListImpParm(rest)
                if (ordering.gt(x, maxRest)) x
                else maxRest
        }

println(maxListImpParm(List(1,2,3,5)))
println(maxListImpParm(List('a','c','b')))
println(maxListImpParm(List("Dog","Cat","bear")))