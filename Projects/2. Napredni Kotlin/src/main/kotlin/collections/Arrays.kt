package collections

fun main() {
    val teachers = arrayOf("Bruno", "Luka", "Filip", "Goran")
    teachers.forEach { println(it) }

    val integers: Array<Int> = arrayOf(1, 2, 3) // Boxed objects -> Integer
    val ints: IntArray = intArrayOf(1, 2, 3) // primitive type -> int
}