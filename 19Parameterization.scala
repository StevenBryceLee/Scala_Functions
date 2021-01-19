class Queue[+T] private (
    private val leading: List[T],
    private val trailing: List[T],
) {

    // defining a lower type bound where T lower bounds U
    def enqueue[U >: T](x: U) = new Queue[U](leading, x :: trailing)

    private def mirror() = 
        if (leading.isEmpty) {
            while (!trailing.isEmpty) {
                leading = trailing.head :: leading
                trailing = trailing.tail
            }
        }
    
    def head: T = {
        mirror()
        leading.head
    }

    def tail: Queue[T] = {
        mirror()
        new Queue(leading.tail, trailing)
    }
}

object Queue {
    def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}

