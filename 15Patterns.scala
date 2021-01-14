sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(op: String, arg: Expr) extends Expr
case class BinOp(op: String, left: Expr, right: Expr) extends Expr

val v = Var("x") //no 'new' keyword needed
val op = BinOp("+", Number(1), v)
val res = op.copy(op = "-")

def describe(x: Any) = x match {
    case BinOp("+", Number(1), v) => "Deep match"
    case BinOp(_,_,_) => s"$x is a binary expression"
    case `v` => s"$v Accessed the v val"
    case n: Int if 0 < n => "pattern guarded positive integer"
    case _ => "Not a binary expression"
}

def sealedDescribe(e: Expr): String = (e: @unchecked) match {
    // Try commenting out a particular case to show what 'sealed' does
    case Number(_) => "Number"
    case Var(_) => "A Var"
    case UnOp(_, _) => "A unOp"
    case BinOp(_, _, _) => "A BinOp"
    
}

println(describe(op))
println(describe(res))
println(describe(v))
println(describe(5))

val num, string = (123, "abc")