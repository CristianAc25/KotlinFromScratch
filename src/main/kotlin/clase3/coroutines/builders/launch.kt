package clase3.coroutines.builders

import clase3.coroutines.log
import kotlinx.coroutines.*

// Builder: launch()

//    public fun CoroutineScope.launch(
//        context: CoroutineContext = EmptyCoroutineContext,
//        start: CoroutineStart = CoroutineStart.DEFAULT,
//        block: suspend CoroutineScope.() -> Unit
//    ): Job
fun main() {
    log("Start")

    runBlocking {
        log("Start of runBlocking")
        launch {
            log("Before delay.")
            delay(1000)
            log("After delay.")
        }
        log("End of runBlocking")
    }

    log("End")
}