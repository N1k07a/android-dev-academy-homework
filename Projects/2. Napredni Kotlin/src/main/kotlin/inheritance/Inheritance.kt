package inheritance

open class Person(
    val name: String,
    val lastName: String
) {
    override fun toString(): String {
        return "My name is $name $lastName"
    }
}

class Job(val name: String, val salary: Double)

open class Worker(
    name: String,
    lastName: String,
    protected val job: Job
) : Person(name, lastName) {

    override fun toString(): String {
        return "My name is $name $lastName. I work as a ${job.name}"
    }
}

class Teacher(
    name: String,
    lastName: String,
    salary: Double
) : Worker(name, lastName, Job("Teacher", salary)) {

    override fun toString(): String {
        return "My name is Mister/Miss $lastName"
    }
}
