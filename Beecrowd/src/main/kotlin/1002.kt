import java.text.DecimalFormat
import java.util.*


fun main() {
    val en = Scanner(System.`in`)
    var x : Double =  readLine()?.toDouble()!!
    x= x*x
    val df = DecimalFormat("0.0000")
    val str = df.format(x*3.14159)
    println("A="+ str)
}