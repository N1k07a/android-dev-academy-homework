package nullability

fun main() {
    val name: String? = null

    if (name != null) println(name.length) else println(0)

    val nameLength = name?.length
    println(nameLength) //output: null

    val nameLengthElvis = name?.length ?: 0
    println(nameLengthElvis)  //output: 0

    println(name!!.length)
}
