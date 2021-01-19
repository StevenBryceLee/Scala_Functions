class Time {
    private[this] var h = 12
    private[this] var m = 0

    def hour: Int = h
    def hour_= (x: Int) = {
        require(0 <= x && x < 24)
        h = x
    }

    def minute = m
    def minute_= (x: Int) = {
        require(0 <= x && x < 60)
        m = x
    }
}

class Thermometer {
    var celsius: Float = _

    def fahrenheit = celsius * 9 / 5 + 32
    def fahrenheit_= (f: Float) = {
        celsius = (f - 32) * 5 / 9
    }
    override def toString = s"${fahrenheit}F/${celsius}"
}

val th = new Thermometer
println(th.celsius)
println(th)
th.celsius = 100
println(th)
th.fahrenheit = -40
println(th)