package kan.kis.testexampleapp.unittests

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kan.kis.testexampleapp.Engine
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @Test
    fun turnOn() {

        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun `rise The TemperatureWhenItTurnsOn`() {
        engine.turnOn()

        assertEquals(95, engine.temperature)

    }

}