package kan.kis.testexampleapp.acceptancetests


import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kan.kis.testexampleapp.Car
import kan.kis.testexampleapp.Engine

import org.junit.Test

class CarFeature {

    private val engine = Engine()
    val car = Car(fuel = 6.0, engine = engine)

    @Test
    fun carIsLoosingFuelWhenInTurnsOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }


    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() {
        car.turnOn()
        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }


}