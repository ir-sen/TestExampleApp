package kan.kis.testexampleapp

class Engine(
    var temperature: Int = 15,
    var isTurnedOn: Boolean = false,
) {

    fun turnOn() {
        isTurnedOn = true

        Thread.sleep(6000)

        temperature = 95
    }
}