package inheritance

interface Attacker {
    fun attack()
}

class Swordsman: Attacker {
    override fun attack() {
        println("Swinging a sword...")
    }
}

class Archer: Attacker {
    override fun attack() {
        println("Drawing a bow...")
    }
}

class Dragon: Attacker {
    override fun attack() {
        println("Breathing fire...")
    }
}

fun main() {
    val boss = Boss(Archer())
    println(boss.attackPlayer())
}

class Boss(private val character: Attacker) {
    fun attackPlayer() {
        character.attack()
    }
}

