package functions

val noParamFunType: () -> Unit = { println("Anything") }

val oneParamFunType: (String) -> Unit = { println(it) }

val funWithReturnType: (String) -> String = { "a" }

val sum: (Int, Int) -> Int = { a, b -> a + b }

val subtract: (Int, Int) -> Int = fun(a, b): Int = a - b

fun add(a: Int, b: Int): Int = a + b

val addReference: (Int, Int) -> Int = ::add

val addedValue: Int = add(2, 3)

val containsVowels: String.() -> Boolean = {
    this.contains("a", true)
            || this.contains("e", true)
            || this.contains("i", true)
            || this.contains("o", true)
            || this.contains("u", true)
}

val unusedParam: (String) -> Unit = { _ -> println("I don't need a param") }
