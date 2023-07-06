package clase3.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    println("Inicio main")

    runBlocking {

        launch {
            delay(300)
            println("Corrutina ejecutandose")
        }
    }

    println("Fin main")
}