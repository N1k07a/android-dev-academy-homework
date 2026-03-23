package delegates

import kotlin.properties.Delegates

fun main() {
    val expensiveObject by lazy { produceExpensiveObject() }
    println(expensiveObject)

    var name by Delegates.observable("Filip") { _, oldValue, newValue ->
        println("Old: $oldValue, new: $newValue")
    }
    name = "Luka"

    val nameToJob = mapOf(
        "filip" to "Compose Dev",
        "luka" to "Android Dev"
    )
    val filip by nameToJob
    println(filip)
}

private fun produceExpensiveObject() = buildString { (0..10).forEach { append("a$it \n") } }
