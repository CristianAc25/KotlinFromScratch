import kotlinx.coroutines.*
import kotlin.coroutines.*


class MyHandledScope: CoroutineScope {

    private val job = Job()
    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        log("Exception Handler: [ ${exception.message} ]")
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default + exceptionHandler

    fun myFirstTask() = launch {
        log("Job start")
        delay(1000)
        log("Job: before throwing exception")
        throw IndexOutOfBoundsException("Job: Working with coroutine exceptions.")
    }

    fun release() {
        this.job.cancel()
    }

}

fun main() {
    log("Start")

    val scope = MyHandledScope()

    runBlocking {
        log("RunBlocking start")

        val job = scope.myFirstTask()
        job.join()

        log("RunBlocking end")
    }

    scope.release()

    log("End")
}
