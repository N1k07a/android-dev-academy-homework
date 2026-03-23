package src.main.kotlin.exercises

fun operate(a: Int, b: Int, operation: (Int, Int) -> Int) {
    println(operation(a, b))
}

fun String.isEmail() = this.contains("@") && this.contains(".")

fun main() {
    operate(5, 3) { x, y -> x + y } // Output: 8
    operate(5, 3) { x, y -> x - y } // Output: 2
    operate(5, 3) { x, y -> x * y } // Output: 15
    operate(5, 3) { x, y -> x / y } // Output: 1
    operate(5, 3) { x, y -> if (x > y) x else y }

    println("pero@gmail.com".isEmail())
}