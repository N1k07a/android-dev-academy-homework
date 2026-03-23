package src.main.kotlin.exercises

import generics.listOf

val peopleAgeList = listOf(12, 21, 16, 30, 18, 55, 40, 24, 32, 28, 31)
val names = listOf(
    "Filip",
    "Luka",
    "Marko",
    "Ana",
    "Ivana",
    "Petar",
    "Jelena",
    "Nikola",
    "Maja",
    "Stjepan",
    "Bruno",
    "David",
    "Lovro",
    "Fran",
    "Ante",
    "Mirko",
)

fun main() {
    val listOfAdults = peopleAgeList.filter { it > 18 }.map { "Adult. Age: $it\n" }
    println(listOfAdults)

    val grouped = names.groupBy { it.first() }
    println(grouped)
    val counted = names.groupingBy { it.first() }.eachCount()
    println(counted)
}