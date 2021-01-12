
class ArrayElement(conts: Array[String]) extends Element {
    def contents: Array[String] = conts
}

val ae = new ArrayElement(Array("Hello", "world"))
// println(ae.width)

class ArrayElement2(
    val contents: Array[String]
) extends Element
val ae2 = new ArrayElement2(Array("Hell", "orld"))
// println(ae2.width)

class LineElement(s: String) extends Element(Array(s)) {
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

object Element {

    class ArrayElement2(
        val contents: Array[String]
    ) extends Element

    class LineElement(s: String) extends Element(Array(s)) {
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

// redefining so element class does not require 'new' keyword
import Element.elem

abstract class Element2 {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length
    
    def above(that: Element): Element = 
        elem(this.contents ++ that.contents)
    
    def beside(that: Element): Element = {
        elem(
            for (
                (line1, line2) <- this.contents zip that.contents
            ) yield line1 + line2
        )
    }

    override def toString = contents mkString "\n"
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

object Spiral {
    val space = elem(" ")
    val corner = elem("+")

    def spiral(nEdges: Int, directions: Int): Element = {
        if (nEdges == 1)
            elem("+")
        else {
            val sp = spiral(nEdges - 1, (direction + 3) % 4)
            def verticalBar = elem('|', 1, sp.height)
            def horizontalBar = elem('-', sp.width, 1)
            if (direction == 0)
                (corner beside horizontalBar) above (sp beside space)
            else if (direction == 1)
                (sp above space) beside (corner above verticalBar)
            else if (direction == 2)
                (space beside sp) above (horizontalBar beside corner)
            else
                (verticalBar above corner) beside (space above sp)
        }
    }
}


class Cat {
    val dangerous = false
}

class Tiger(
    override val dangerous: Boolean,
    private var age: Int
) extends Cat

class Tiger2( param1: Boolean, param2: Int) extends Cat {
    override val dangerous = param1
    private var age = param2
}