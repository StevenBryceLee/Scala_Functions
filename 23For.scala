// for ( sequence ) yield expression

val forRes = for (x <- List(1,2); y <- List("one", "two")) yield (x,y)
println(forRes)

def inCheck(q1: (Int, Int), q2: (Int, Int)) = 
    q1._1 == q2._1 ||
    q1._2 == q2._2 ||
    (q1._1 - q2._1).abs == (q1._2 - q2._2).abs

def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) = 
    queens forall (q => !inCheck(queen, q))

def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] = 
        if (k == 0)
            List(List())
        else
            for {
                queens <- placeQueens(k - 1)
                column <- 1 to n
                queen = (k, column)
                if isSafe(queen, queens)
            } yield queen :: queens
    placeQueens(n)
}

println(queens(8).head)

