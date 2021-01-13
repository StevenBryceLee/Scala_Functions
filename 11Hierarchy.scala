def isEqual(x: Int, y: Int) = x == y
println(isEqual(420,420))

def isEqual2(x: Any, y: Any) = x == y
println(isEqual2(421,421))

println("abcd".substring(2) == "abcd".substring(2))

println("eq is different from ==, referring to reference")
val x = new String("abc")
val y = new String("abc")
println(x eq y)
println(x ne y)

// class SwissFrancs(val amount: Int) extends AnyVal {
//     override def toString() = s"$amount CHF"
// }

class Vclass(val a: Int) {
    override def toString() = a.toString
}

val money = new Vclass(100)
println(money)
println(money.a)
