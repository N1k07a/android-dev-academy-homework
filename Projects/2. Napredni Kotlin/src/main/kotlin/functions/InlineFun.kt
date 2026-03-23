package functions

fun main() {
    runSomeCode {
        println("Hello there!")
    }
}

inline fun runSomeCode(codeToRun: () -> Unit) {
    codeToRun()
}
