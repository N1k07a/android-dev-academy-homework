package homework

class BankAccount(private val accountNumber: String) {

    private var _balance: Double = 0.0

    val balance: Double
        get() = _balance

    companion object {
        var totalAccountsCreated = 0
            private set
    }

    init {
        totalAccountsCreated++
    }

    fun deposit(amount: Double) {
        if (amount > 0) {
            _balance += amount
            TransactionLogger.log("Deposited $amount € to $accountNumber. New balance: $_balance €")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= _balance) {
            _balance -= amount
            TransactionLogger.log("Withdrew $amount € from $accountNumber. New balance: $_balance €")
        } else {
            TransactionLogger.log("Failed withdrawal on $accountNumber. Insufficient funds.")
        }
    }
}