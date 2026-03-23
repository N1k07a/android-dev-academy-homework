package functions

fun main() {
    val number = 5

    println(number.squared())
}

fun Int.squared(): Int = this * this
