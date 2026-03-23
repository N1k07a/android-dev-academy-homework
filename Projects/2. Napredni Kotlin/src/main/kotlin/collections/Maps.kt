package collections

fun main() {
    val nameToJob = mapOf(
        "Filip" to "Compose Dev",
        "Luka" to "Android Dev"
    )

    val nameJobPair: Pair<String, String> = "Bruno" to "Professor"

    nameToJob.run {
        println(count())
    }

    nameToJob.forEach { (key, value) -> println("$key: $value") }
    println(nameToJob.keys)
    println(nameToJob.values)
    println(nameToJob.entries)
}