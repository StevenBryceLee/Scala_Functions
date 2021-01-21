// discusses implementation of collections in scala
//Reference this chapter for which functions are only abstract 

import scala.collection.{View, mutable}
import scala.collection.immutable.{IndexedSeq, IndexedSeqOps}

abstract class Base
case object A extends Base
case object U extends Base
case object G extends Base
case object C extends Base

object Base {
    val fromInt: Int => Base = Array(A, U, G, C)
    val toInt: Base => Int = Map(A -> 0, U -> 1, G -> 2, C -> 3)
}

final class RNA private (val groups: Array[Int], 
    val length: Int) extends IndexedSeq[Base]
    with IndexedSeqOps[Base, IndexedSeq, RNA] {

        // Implemented on 660
    }
    