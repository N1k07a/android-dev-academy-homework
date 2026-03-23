package src.main.kotlin.exercises

abstract class SmartDevice {
    abstract val name: String
    abstract val isOn: Boolean

    fun turnOn() {
        println("Turning on $name")
    }

    fun turnOff() {
        println("Turning off $name")
    }
}

interface Dimmable {
    fun adjustLight(percentage: Int)
}

class LightBulb(override val name: String, override val isOn: Boolean) : SmartDevice(), Dimmable {
    override fun adjustLight(percentage: Int) {
        println("Adjusting light of $name to $percentage%")
    }
}

class SmartFridge(override val name: String, override val isOn: Boolean) : SmartDevice()

class Controller(val smartDevice: SmartDevice) {
    fun controlDevice() {
        smartDevice.turnOn()
        if (smartDevice is Dimmable) {
            smartDevice.adjustLight(50)
        }
        smartDevice.turnOff()
    }
}