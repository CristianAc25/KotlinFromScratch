import kotlinx.coroutines.*
import kotlin.coroutines.*


class MyScope: CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default + CoroutineName("CoRuTiNa")

    fun myFirstTask() = launch {
        log("MyTask 1: Starts")
        delay(3000)
        log("MyTask 1: before throwing exception")
        throw IndexOutOfBoundsException("MyTask: Working with coroutine exceptions.")
    }

    fun mySecondTask() = launch {
        log("MyTask 2: Starts")

        (1..Int.MAX_VALUE).forEach {
            delay(1000)
            log("MyTask 2: repetition $it")
        }
    }

    fun release() {
        this.job.cancel()
    }

}

fun main() {
    log("Start")

    val myScope = MyScope()

    runBlocking {
        log("RunBlocking start")

        val job1 = myScope.myFirstTask()
        val job2 = myScope.mySecondTask()

        job1.invokeOnCompletion {exception ->
            if (exception != null) log("Job 1 On Completion - Exception: [ $exception ]")
        }

        job2.invokeOnCompletion {exception ->
            if (exception != null) log("Job 2 On Completion - Exception: [ $exception ]")
        }

        joinAll(job1, job2)

        log("RunBlocking end")
    }

    myScope.release()

    log("End")
}
