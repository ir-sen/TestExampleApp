package kan.kis.testexampleapp.unittests

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import kan.kis.testexampleapp.Car
import kan.kis.testexampleapp.Engine
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify


class CarShould {

    private val engine: Engine = mock()
    private val car = Car(engine, 5.0)


    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun loosingFuelWhenInTurnsOn() = runBlockingTest {
        car.turnOn()

        assertEquals(4.5, car.fuel)

        verify(engine, times(1)).turnOn()
    }


}