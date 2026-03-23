package generics

// Covariance -> out T (Producer of T)
interface Producer<out T> {
    fun produce(): T
}

// Source<String> is a subtype of Source<Any>
fun demo(strs: Producer<String>) {
    val objects: Producer<Any> = strs // This is OK, since T is an out-parameter
    // ...
}

// Contravariance -> in T (Consumer of T)
interface Consumer<in T> {
    fun consume(other: T): Int
}


fun demo(x: Consumer<Number>) {
    x.consume(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, you can assign x to a variable of type Comparable<Double>
    val y: Consumer<Double> = x // OK!
}

fun <T> countGreater(list: List<T>, threshold: T): Int where T : CharSequence, T : Comparable<T> {
    return list.count { it > threshold }
}


fun main() {
    val stringSource = object : Producer<String> {
        override fun produce() = "This is a string"
//        override fun nextT() = 505
    }

    val threshold = "He"
    val strings = listOf("Filip", "Marin", "Ivan", "Tomislav")

    val greaterStrings = countGreater(strings, threshold)

    println(greaterStrings)
}




