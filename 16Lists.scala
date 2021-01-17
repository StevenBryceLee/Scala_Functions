val nums = List(1,2,3,4)
val nums2 = 1 :: (2 :: (3 :: (4 :: Nil)))
val nums3 = 1 :: 2 :: 3 :: 4 :: Nil
println(nums)
println(nums2)
println(nums3)

def insert(x: Int, xList: List[Int]): List[Int] = 
    if (xList.isEmpty || x <= xList.head) x :: xList
    else xList.head :: insert(x, xList.tail)

def insertSort(xList: List[Int]): List[Int] = 
    if (xList.isEmpty) Nil
    else insert(xList.head, insertSort(xList.tail))

println(insertSort(List(4,3,2,1,0)))

val List(a, b, c, d) = nums
println(a, b, c, d)

val twoList = List(1,2)
val threeList = List(1,2, 3)
val fiveList = twoList ::: threeList
println(fiveList)

println("\nList methods\n")

val abcde = List('a','b','c','d','e')
println(abcde.last)
println(abcde.init)
println(abcde.reverse)
println(abcde take 2)
println(abcde drop 2)
println(abcde splitAt 2)
println(abcde.indices)
println(abcde.indices zip abcde)
val buf = new StringBuilder
println(abcde.addString(buf, "(", ";", ")"))

val flattenedList = List(List(1,2), List(), List(3)).flatten
println(flattenedList)

println("\nHigher order methods\n")
println(nums map(_ + 1))
val words = List("the", "quick", "brown", "fox")
println(words map(_.toList.reverse.mkString))
println(words map (_.toList))
println(words flatMap (_.toList))
println(nums filter (_ % 2 == 0))
println(nums partition (_ % 2 == 0))
println(nums find (_ % 2 == 0))
println(nums takeWhile (_ < 3))
println(nums dropWhile (_ < 3))
println(nums span (_ < 3))
println(nums forall (_ > 0))
println(nums exists (_ == 0))
println(words.foldLeft("")(_ + " " + _))
println(words.tail.foldLeft(words.head)(_ + " " + _))
println(words sortWith (_.length > _.length))
println(List.fill(5)("Fox"))
println(List.tabulate(5,5)(_ * _))
println((nums lazyZip List.range(0,nums.length)).map(_ * _))

