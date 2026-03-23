package collections

fun main() {
    val teachers = setOf("Bruno", "Luka", "Filip", "Goran", "Luka", "Filip")
    teachers.run {
        println(count())
        println(last())
        println(filter { it.length > 4 })
    }
    println(teachers)
}