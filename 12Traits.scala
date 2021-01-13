trait Philisophical {
    def philosophize() = {
        println("I take space, therefore I am")
    }
}

class Animal

class Frog extends Animal with Philisophical {
    override def toString = "Green"
}

val frog = new Frog
println(frog)

frog.philosophize()

class Point(val x: Int, val y: Int)
trait Rectangular {
    def topLeft: Point
    def bottomRight: Point

    // and many other rectangle traits
}

// ordered trait replaces all <= == >= comparisons with compare fn
class Rational(n: Int, d: Int) extends Ordered[Rational] {
     require(d != 0)
     private val g = gcd(n.abs, d.abs)
     val numer: Int = n / g
     val denom: Int = d / g
     def this(n: Int) = this(n, 1)

     override def toString = s"$numer/$denom"
     def + (that: Rational): Rational = 
          new Rational(numer * that.denom + that.numer * denom,
                         denom * that.denom
                         )

     def + (i: Int): Rational = 
          new Rational(numer + i * denom, denom)

     def - (that: Rational): Rational = 
          new Rational(numer * that.denom - that.numer * denom, 
                         denom * that.denom)

     def * (that: Rational): Rational = 
          new Rational(numer * that.numer, denom * that.denom)
    //  def lessThan(that: Rational) = 
    //       this.numer * that.denom < that.numer * this.denom

    def compare(that: Rational) = 
        (this.numer * that.denom) - (that.numer * this.denom)

     def max(that: Rational) = 
          if (this < that) that else this

     private def gcd(a: Int, b: Int): Int = 
          if (b == 0) a else gcd(b, a % b)
}

val half = new Rational(1,2)
val third = new Rational(1,3)
println(half < third)
println(half > third)

abstract class IntQueue {
    def get(): Int
    def put(x: Int): Unit
}

trait Doubling extends IntQueue {
    abstract override def put(x: Int) = { super.put(2 * x) }
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]
    def get() = buf.remove(0)
    def put(x: Int) = { buf += x }
}

val q = new BasicIntQueue
q.put(10)
q.put(20)
println(q.get())
println(q.get())

class doubleQ extends BasicIntQueue with Doubling

val qu = new doubleQ
qu.put(10)
qu.put(20)
println(qu.get())
println(qu.get())

trait Incrementing extends IntQueue {
    abstract override def put(x: Int) = { super.put(x + 1) }
}

trait Filtering extends IntQueue {
    abstract override def put(x: Int) = { if (x >= 0) super.put(x)}
}

// Rightmost are added first
val que = (new BasicIntQueue with Incrementing with Filtering)
que.put(-1)
que.put(0)
que.put(1)
println(que.get())
println(que.get())

