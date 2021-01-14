import org.scalatest._


class HelloSpec extends FunSuite with DiagrammedAssertions {
  test("Hello should start with H") {
    assert("Hello".startsWith("H"))
  }
  test("Hello with assertResult") {
      assertResult("Hello") {
          "Hello"
      }
  }
  test("assertThrows example") {
      assertThrows[IllegalArgumentException] {
          def testAdd(x: Int, y: Int): Int = {
              if (x < 0) throw new IllegalArgumentException
              x + y
          }
          testAdd(-1,2)
      }
  }

}