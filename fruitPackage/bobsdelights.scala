package bobsdelights

abstract class Fruit(
    val name: String,
    val color: String
)

object Fruits {
    object Apple extends Fruit("Apple", "red")
    object Orange extends Fruit("orange", "orange")
    object Pear extends Fruit("pear", "yellow")
    val menu = List(Apple, Orange, Pear)
}

import bobsdelights.Fruit