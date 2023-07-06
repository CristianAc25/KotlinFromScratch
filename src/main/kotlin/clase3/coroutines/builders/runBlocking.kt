package clase3.coroutines.builders

import clase3.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// Builder: runBlocking()

//    public fun <T> runBlocking(
//        context: CoroutineContext = EmptyCoroutineContext,
//        block: suspend CoroutineScope.() -> T
//    ): T
fun main() {
    log("Start")

    runBlocking {
        log("Before delay.")
        delay(1000)
        log("After delay.")
    }

    log("End")
}