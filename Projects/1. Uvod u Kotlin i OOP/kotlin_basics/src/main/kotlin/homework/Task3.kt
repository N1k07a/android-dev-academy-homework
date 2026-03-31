package homework

fun main() {
    val weeklySteps = listOf(5000, 12000, 8000, 15000, 3000, 11000, 9500)
    var totalSteps = 0

    for (dailySteps in weeklySteps) {
        totalSteps += dailySteps
    }

    println("Total number of steps this week: $totalSteps")

    var index = 0

    while(index < weeklySteps.size) {
       if(weeklySteps[index] > 10000) {
           println("First day that you reached 10k steps was the ${index + 1}. day of the week, ${weeklySteps[index]} steps, well done!")
           break
       }
        index++
    }
}