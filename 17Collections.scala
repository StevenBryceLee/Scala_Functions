val fiveIntArr = new Array[Int](5)
println(fiveIntArr)

import scala.collection.mutable.ListBuffer
val buf = new ListBuffer[Int]
buf += 1
buf += 2
3 +=: buf
println(buf.toList)


import scala.collection.mutable.ArrayBuffer
val bufArr = new ArrayBuffer[Int]()
bufArr += 3
bufArr += 4
println(bufArr)

val nums = Set(1,2,3)
nums + 5
nums - 3
nums ++ List(5,6)
println(nums)
nums -- List(1,2)
nums & Set(1,3,5,7)
println(nums)


import scala.collection.immutable.TreeSet
val ts = TreeSet(3,4,5,1,2)
println(ts)

import scala.collection.immutable.TreeMap
var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
tm += (2 -> 'x')
println(tm)

val tsList = ts to List
println(tsList)

