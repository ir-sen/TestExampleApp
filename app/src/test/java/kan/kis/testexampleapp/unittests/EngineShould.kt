package kan.kis.testexampleapp.unittests

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kan.kis.testexampleapp.Engine
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun turnOn() = runBlockingTest {

        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun `rise The TemperatureWhenItTurnsOn`() = runBlockingTest {
        engine.turnOn()

        assertEquals(95, engine.temperature)

    }

}