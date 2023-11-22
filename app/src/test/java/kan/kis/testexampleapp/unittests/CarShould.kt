package kan.kis.testexampleapp.unittests

import junit.framework.TestCase.assertEquals
import kan.kis.testexampleapp.Car
import kan.kis.testexampleapp.Engine
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify


class CarShould {

    private val engine: Engine = mock()
    private val car = Car(engine, 5.0)


    @Test
    fun loosingFuelWhenInTurnsOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel)

        verify(engine, times(1)).turnOn()
    }


}