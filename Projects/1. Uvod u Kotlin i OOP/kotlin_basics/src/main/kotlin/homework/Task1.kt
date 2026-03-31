package homework

fun main() {
    val name = "Peter"
    val surname = "Parker"
    var email: String? = null
    var age: Int? = 23

    println("Email length: ${email?.length}")
    email = "peter.parker@gmail.com"
    println("Email length: ${email?.length}")
    if (age != null) {
        age += 1
    }
    println("USER: $name $surname, EMAIL: $email, AGE: $age")
}
