package homework

fun main() {
    val username = readln()

    println("Username: $username, is valid: ${isValid(username.normalizeUsername())}")
}

fun normalizeUsername(input: String) = input.trim().lowercase()

// Extension function
fun String.normalizeUsername(): String {
    return this.trim().lowercase()
}

fun isValid(username: String): Boolean {
    if(username.isBlank()){
        return false
    }
    val isLongEnough = username.length in 5..15
    val startsWithLetter = username[0].isLetter()
    val containsValidCharacters = username.all { it.isLetterOrDigit() || it == '_' }
    val containsSpaces = username.contains(" ")

    return isLongEnough && startsWithLetter && containsValidCharacters && !containsSpaces
}