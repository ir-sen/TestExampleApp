package kan.kis.testexampleapp

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class Car(
    val engine: Engine,
    var fuel: Double,
    ) {

    fun turnOn() {
        fuel -= 0.5
        // we use coroutine to invoke suspend function
        CoroutineScope(Dispatchers.Main).launch {
            // invoke flow
            engine.turnOn().collect {temp ->
                Log.d("COUESE", "collected engine temperature: $temp")
            }
        }
    }


}