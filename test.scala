package Elements

import Element.elem

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

abstract class Element {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length
    
    def above(that: Element): Element = 
        new ArrayElement(this.contents ++ that.contents)
    
    def beside(that: Element): Element = {
        new ArrayElement(
            for (
                (line1, line2) <- this.contents zip that.contents
            ) yield line1 + line2
        )
    }

    def widen(w: Int): Element =
        if (w <= width) this
        else {
            val left = elem(' ', (w - width) / 2, height)
            val right = elem(' ', w - width - left.width, height)
            left beside this beside right
        }

    def heighten(h: Int): Element = 
        if (h <= height) this
        else {
            val top = elem(' ', width, (h - height) / 2)
            val bot = elem(' ', width, h - height - top.height)
            top above this above bot
        }

    override def toString = contents mkString "\n"
}


class ArrayElement(conts: Array[String]) extends Element {
    def contents: Array[String] = conts
}


class UniformElement(
    ch: Char, 
    override val width: Int,
    override val height: Int
) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
}


object Element {

    class ArrayElement(
        val contents: Array[String]
    ) extends Element

    class LineElement(s: String) extends Element {
        def contents: Array[String] = Array(s)
        override def width = s.length
        override def height = 1
    }

    class UniformElement(
        ch: Char, 
        override val width: Int,
        override val height: Int
    ) extends Element {
        private val line = ch.toString * width
        def contents = Array.fill(height)(line)
    }


    def elem(contents: Array[String]): Element = 
        new ArrayElement(contents)
    
    def elem(chr: Char, width: Int, height: Int): Element = 
        new UniformElement(chr, width, height)

    def elem(line: String): Element = new LineElement(line)
}
