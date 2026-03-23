package delegates

interface Engineer {
    fun buildApp()
    fun testApp()
    fun writeNewBackendApi()
}

class SeniorEngineer : Engineer {
    override fun buildApp() {
        println("I'm building a new Android app!")
    }

    override fun testApp() {
        println("No bugs found! Ready to launch...")
    }

    override fun writeNewBackendApi() {
        println("Creating user endpoints.")
    }
}

class Manager(engineer: Engineer) : Engineer by engineer {
    fun organizeMeeting() {
        println("Let's have a sprint planning!")
    }
}

fun main() {
    val filip = SeniorEngineer()
    val pero = Manager(engineer = filip)
    pero.organizeMeeting()
    pero.buildApp()
}