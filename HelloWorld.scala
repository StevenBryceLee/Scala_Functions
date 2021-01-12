// println("Hello, world, from a script!")
// println("Hello, " + args(0) + "!")
// var i = 0
/*while(i < args.length) {
     if (i != 0)
          print(" ")
     print(args(i))
     i += 1
}
println()
args.foreach((arg: String) => print(arg + " "))
println()
args.foreach(println)
*/
// for (arg <- args)
     // println(arg)

// val greetString = new Array[String](3)
// greetString(0) = "Hello"
// greetString(1) = "Hello2"
// greetString(2) = "Hello3"
// for (i <- 0 to 2)
//      print(greetString(i))
// // Equivalent
// greetString.update(0, "hello")
// greetString.update(1, ", ")
// greetString.update(2, "World!\n")
// for (i <- 0.to(2))
//      print(greetString.apply(i))

// val nums = Array("zero", "one", "two")
// val oneTwoThree = List(1,2,3)
// val fourfive = List(4,5)
// append operation
// val all = oneTwoThree ::: fourfive
// println(oneTwoThree + " and " + fourfive + " were not mutated")
// println("Thus, " + all + " is a new list.")
// val TwoThree = List(2,3)



// Methods ending in a colon are right associative
// val secondOneTwoThree = 1 :: TwoThree
// val thirdOneTwoThree = List(1) ::: TwoThree
// println(secondOneTwoThree)
// println(thirdOneTwoThree)

// val pair = (99, "Luft ballons")
// println(pair._1)
// println(pair._2)

// var jetSet = Set("Boeing", "Airbus")
// jetSet += "Lear"
// println(jetSet.contains("Cessna"))

// import scala.collection.mutable
// val movieSet = mutable.Set("Hitch", "Poltergeist")
// movieSet += "Shrek"
// println(movieSet)

// import scala.collection.mutable
// val treasureMap = mutable.Map[Int, String]()
// treasureMap += (1 -> "Go to island.")
// treasureMap += (2 -> "Find big X on ground.")
// treasureMap += (3 -> "Dig.")
// println(treasureMap(2))

// import scala.io.Source
// // for (line <- Source.fromFile("books.txt").getLines())
// //      println(line.length.toString + 1 " " + line)

// val lines = Source.fromFile("books.txt").getLines().toList
// def widthOfLength(s: String) = s.length.toString.length
// var maxWidth = 0
// for (line <- lines)
//      maxWidth = maxWidth.max(widthOfLength(line))
// // without vars, only vals
// val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
// val maxWidthSecond = widthOfLength(longestLine)
// for (line <- lines) {
//      val numSpaces = maxWidthSecond - widthOfLength(line)
//      val padding = " " * numSpaces
//      println(padding + line.length + " | " + line)
// }

// class ChecksumAccumulator {
//      private var sum = 0
//      def add(b: Byte): Unit = sum += b
//      def checksum(): Int = ~(sum & 0xFF) + 1
// }
// import scala.collection.mutable
// object ChecksumAccumulator{
//      private val cache = mutable.Map.empty[String, Int]
//      def calculate(s: String): Int = 
//           if (cache.contains(s))
//                cache(s)
//           else {
//                val acc = new ChecksumAccumulator
//                for (c <- s)
//                     acc.add(c.toByte)
//                val cs = acc.checksum()
//                cache += (s -> cs)
//                cs
//           }
// }

// object Summer {
//      def main(args: Array[String]) = {
//           for (arg <- args)
//                println(arg + ": " + ChecksumAccumulator.calculate(arg))
//      }
// }

// class Rational(n: Int, d: Int) {
//      require(d != 0)
//      private val g = gcd(n.abs, d.abs)
//      val numer: Int = n / g
//      val denom: Int = d / g
//      def this(n: Int) = this(n, 1)

//      override def toString = s"$numer/$denom"
//      def + (that: Rational): Rational = 
//           new Rational(numer * that.denom + that.numer * denom,
//                          denom * that.denom
//                          )

//      def + (i: Int): Rational = 
//           new Rational(numer + i * denom, denom)

//      def - (that: Rational): Rational = 
//           new Rational(numer * that.denom - that.numer * denom, 
//                          denom * that.denom)

//      def * (that: Rational): Rational = 
//           new Rational(numer * that.numer, denom * that.denom)
//      def lessThan(that: Rational) = 
//           this.numer * that.denom < that.numer * this.denom

//      def max(that: Rational) = 
//           if (this.lessThan(that)) that else this

//      private def gcd(a: Int, b: Int): Int = 
//           if (b == 0) a else gcd(b, a % b)
     
     
// }

// val x = new Rational(1,2)
// val y = new Rational(1,4)
// val z = x + y

// println(z)

// val filesHere = (new java.io.File(".")).listFiles
// for (file <- filesHere if file.getName.endsWith(".scala"))
// println(file)
// println("x")
// for (i <- 1 to 4)
// println("Iteration " + i)
// println("Next")
// for (i <- 1 until 4)
// println("Iteration " + i)
// def fileLines(file: java.io.File) = 
//      scala.io.Source.fromFile(file).getLines().toArray
// def grep(pattern: String) = 
//      for (file <- filesHere if file.getName.endsWith(".scala");
//           line <- fileLines(file)
//           if line.matches(pattern))
//           println(s"$file: ${line.trim}")
// grep(".*gcd.*")

// val forLineLengths = 
//      for {
//           file <- filesHere
//           if file.getName.endsWith(".scala")
//           line <- fileLines(file)
//           trimmed = line.trim
//           if trimmed.matches(".*for.*")
//      } yield trimmed.length

// def scalaFiles = 
// for {
//      file <- filesHere
//      if file.getName.endsWith(".scala")
// } yield file

// val n = 4
// val half = 
// if (n % 2 == 0)
//      n / 2
// else
//      throw new RuntimeException("n must be even")
// println(half)

// import java.io.FileReader
// import java.io.FileNotFoundException
// import java.io.IOException

// try {
//      val f = new FileReader("input.txt")
// } catch {
//      case ex: FileNotFoundException =>
//      println("File not found")
//      case ex: IOException =>
//      println("IO Except")
// } finally {
//      println("File closed")
// }

// import java.net.URL
// import java.net.MalformedURLException

// def urlFor(path: String) =
//      try {
//           new URL(path)
//      } catch {
//           case e: MalformedURLException =>
//                new URL("Http://www.scala-lang.org")
//      }
// urlFor("htxq://fff.scales-long.fam")


// val firstArg = if (args.length > 0) args(0) else ""

// val friend = 
//      firstArg match {
//           case "salt" => ("pepper")
//           case "eggs" => ("bacon")
//           case _ => ("huh?")
//      }
// println(friend)

// import scala.util.control.Breaks._
// import java.io._

// val in = new BufferedReader(new InputStreamReader(System.in))
// breakable {
//      var i = 0
//      while (true) {
//           println(i)
//           if (i == 3) break
//           i += 1
//      }
// }


// def makeRowSeq(row: Int) = 
//      for (col <- 1 to 10) yield {
//           val prod = (row * col).toString
//           val padding = " " * (4 - prod.length)
//           padding + prod
//      }
// def makeRow(row: Int) = makeRowSeq(row).mkString
// def multiTable() = {
//      val tableSeq =
//           for (row <- 1 to 10)
//           yield makeRow(row)
//      tableSeq.mkString("\n")
// }

// println(multiTable())


// import scala.io.Source 

// object LongLines {
//      // def processFile(filename: String, width: Int) = {
//      //      val source = Source.fromFile(filename)
//      //      for (line <- source.getLines())
//      //           processLine(filename, width, line)
//      // }
//      // private def processLine(filename: String, width: Int, line: String) = {
//      //      if (line.length > width) 
//      //           println(filename + ": " + line.trim)
//      // }
//      def processFile(filename: String, width: Int) = {
//           def processLine(line: String) = {
//                if(line.length > width)
//                     println(filename + ": " + line.trim)
//           }

//           val source = Source.fromFile(filename)
//           for (line <- source.getLines())
//                processLine(line)
//      }
// }


// val ll = LongLines
// ll.processFile("books.txt", 10)


// object FindLongLines {
//      def main(args: Array[String]) = {
//           val width = args(0).toInt
//           for (arg <- args.drop(1))
//                LongLines.processFile(arg, width)
//      }
// }


// var increase = (x: Int) => x + 1
// val nums = List(-10, -5, 0, 5, 10)
// nums.foreach((x: Int) => println(x))

// nums.filter((x: Int) => x > 0).foreach((x: Int) => println(x))
// nums.filter(x => x > 0).foreach(x => println(x))
// nums.filter(_ > 0).foreach(println(_))

// def sum(a: Int, b: Int, c: Int) = a + b + c
// val a = sum _
// println(a(1,2,3))
// val b = sum(1, _: Int, 3)
// println(b(2))

// def echo(args: String*) = 
//      for (arg <- args) println(arg)
// echo()
// echo("Hello")
// echo("Hello", "World")

// val sq = Seq("Whats", "Up", "Doc")
// echo(sq: _*)

// def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)
// val numList = List(0,1,2,3,4)
// println(containsOdd(numList))

def curriedSum(x: Int)(y: Int) = x + y
println(curriedSum(1)(2))

val twoPlus = curriedSum(2)_
println(twoPlus(2))

val assertionsEnabled = true

def byNameAssert(predicate: => Boolean) = 
     if (assertionsEnabled && !predicate)
          throw new AssertionError

println(byNameAssert(5 == 3))