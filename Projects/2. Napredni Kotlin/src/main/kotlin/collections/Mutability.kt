package collections

fun main() {
    val myList = mutableListOf(1, 2, 3)
    myList.add(4)
    myList.remove(1)
    println(myList)

    val mySet = mutableSetOf(1, 2, 3)
    mySet.add(4)
    mySet.remove(1)
    println(mySet)

    val myMap = mutableMapOf(
        1 to "Luka",
        2 to "Filip",
        3 to "Bruno"
    )
    myMap.put(4, "Goran")
    myMap[5] = "David"
    myMap.remove(1)
    println(myMap)
}