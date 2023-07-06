package clase3.coroutines.builders

import clase3.coroutines.log
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// Builder: async()

//    public fun <T> CoroutineScope.async(
//        context: CoroutineContext = EmptyCoroutineContext,
//        start: CoroutineStart = CoroutineStart.DEFAULT,
//        block: suspend CoroutineScope.() -> T
//    ): Deferred<T>
fun main() {
    log("Start")

    runBlocking {
        log("Start of runBlocking")
        val number = async {
            log("Before delay.")
            delay(1000)
            log("After delay.")
            (1..100).random()
        }
        log("Continue with runBlocking...")
        log("End of runBlocking with value ${number.await()}")
    }

    log("End")
}