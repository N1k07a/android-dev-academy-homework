package classes

data class User(
    val name: String,
    val lastName: String,
    val job: String,
)

fun main() {
    val filip = User("Filip", "Babic", "Compose Dev")
    val filipClone = filip.copy()

    val (name, lastName, job) = filip // Destructuring

    println(filip == filipClone)
    println(filip)
}
