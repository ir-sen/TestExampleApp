package kan.kis.testexampleapp.unittests

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kan.kis.testexampleapp.Engine
import kotlinx.coroutines.flow.toList
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
    fun `rise when The TemperatureWhenItTurnsOn`() = runBlockingTest {
        // get flow which we need test
        val flow = engine.turnOn()
        // convert to list
        val actual = flow.toList()
        // compare expected list and our flow
        assertEquals(listOf(25, 50, 95), actual)

    }

}