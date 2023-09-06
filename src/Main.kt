// this is here because of AP Principles, REPLIT is really slow, and my computer can run this faster
import java.util.Scanner
fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    print("length: ")
    var length:Double = reader.nextDouble()

    print("width: ")
    var width:Double = reader.nextDouble()

    var area: Double
    area = length * width

    var perimeter: Double
    perimeter = (length * 2) + (width * 2)
    println("area: $area")
    println("perimeter: $perimeter")
}

/*
length: 143
width: 82
area: 11726.0
perimeter: 450.0

Process finished with exit code 0
 */