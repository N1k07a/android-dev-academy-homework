package homework

fun main() {
    val bankAccount = BankAccount("12345")

    println("Total accounts ${BankAccount.totalAccountsCreated}")
    bankAccount.deposit(120.0)
    println("Balance: ${bankAccount.balance}")
    bankAccount.withdraw(30.0)

    val bankAccount2 = BankAccount("2468")

    bankAccount2.withdraw(10.0)
    bankAccount2.deposit(50.0)

    println("Total accounts ${BankAccount.totalAccountsCreated}")

}