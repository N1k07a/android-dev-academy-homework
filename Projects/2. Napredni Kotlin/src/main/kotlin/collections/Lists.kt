package collections

fun main() {
    val teachers = listOf("Bruno", "Luka", "Filip", "Goran")
    teachers.run {
        println(count())
        println(first())
        println(find { it.startsWith('L') })
    }

    teachers.forEach { println(it.length) }

    teachers.forEachIndexed { index, teacher -> println("$teacher at $index") }

    for (teacher in teachers) {
        println(teacher.length)
    }
}