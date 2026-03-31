package homework

fun main() {
    println("Enter a number between 1 and 4:")
    val productCode = readln().toInt()

    val drink = when(productCode) {
        1 -> "Water"
        2 -> "Cola"
        3 -> "Juice"
        4 -> "Coffee"
        else -> "Unknown"
    }

    val drinkPrice: Double = when(drink) {
        "Water" -> 1.0
        "Cola", "Juice" -> 3.5
        "Coffee" -> 2.0
        else -> 0.0
    }

    println("Price of selected product: $drinkPrice €")
    println("Insert money: ")

    var receivedMoney: Double = readln().toDouble()

    if(receivedMoney >= drinkPrice) {
        receivedMoney -= drinkPrice
        println("Pouring a $drink, change $receivedMoney €.")
    } else {
        println("Insufficient amount of money, another ${drinkPrice - receivedMoney} € is needed for the selected drink.")
    }
}
