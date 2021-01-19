trait Abstract {
    type T
    def transform(x: T): T
    val initial: T
    var current: T
}

class Concrete extends Abstract {
    type T = String
    def transform(x: String) = x + x
    val initial = "hi"
    var current = initial
}

val conc = new Concrete
println(conc.current)

trait RationalTrait {
    val numerArg: Int
    val denomArg: Int
    require(denomArg != 0) // This will cause defaultZeroArgs below to throw exception
    private val g = gcd(numerArg, denomArg)
    val numer = numerArg / g
    val denom = denomArg / g
    private def gcd(a: Int, b: Int): Int = 
        if (b == 0) a else gcd(b, a % b)
    override def toString = s"$numer/$denom"
}

// This will throw an exception
// val defaultZeroArgs = new RationalTrait {
//     val numerArg = 1 * x
//     val denomArg = 2 * x
// }

val x = 2

val preInitialized = new {
    val numerArg = 1 * x
    val denomArg = 2 * x
} with RationalTrait

println(preInitialized)

object twoThirds extends {
    val numerArg = 2
    val denomArg = 3
} with RationalTrait

trait LazyRationalTrait {
    val numerArg: Int
    val denomArg: Int
    lazy val numer = numerArg / g
    lazy val denom = denomArg / g
    override def toString = s"$numer/$denom"
    private lazy val g = {
        require(denomArg != 0)
        gcd(numerArg, denomArg)
    }
    private def gcd(a: Int, b: Int): Int = 
        if (b == 0) a else gcd(b, a % b)
}



val LazyRat = new LazyRationalTrait{
    val numerArg = 1 * x
    val denomArg = 2 * x
}

println(LazyRat)

class Food
abstract class Animal {
    type SuitableFood <: Food
    def eat(food: SuitableFood): Unit
}

class Grass extends Food
class Cow extends Animal {
    type SuitableFood = Grass
    override def eat(food: Grass) = {}
}

class Pasture {
    var animals: List[Animal {type SuitableFood = Grass}] = Nil
}

object Color extends Enumeration {
    val Red, Green, Blue = Value
}

object Direction extends Enumeration {
    val North = Value("North")
    val East = Value("East")
    val South = Value("South")
    val West = Value("West")
}
for (c <- Color.values) print(c + " ")
for (d <- Direction.values) print(d + " ")
