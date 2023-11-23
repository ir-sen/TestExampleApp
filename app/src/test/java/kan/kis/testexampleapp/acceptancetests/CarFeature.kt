package kan.kis.testexampleapp.acceptancetests


import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kan.kis.testexampleapp.Car
import kan.kis.testexampleapp.Engine
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule

import org.junit.Test

class CarFeature {

    private val engine = Engine()
    val car = Car(fuel = 6.0, engine = engine)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenInTurnsOn() = runBlockingTest {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }


    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() = runBlockingTest {
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(7999)

        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }


}