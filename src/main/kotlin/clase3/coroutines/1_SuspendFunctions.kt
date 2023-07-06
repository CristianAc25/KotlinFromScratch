package clase3.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun log(message: String) {
    println("[${Thread.currentThread().name}] : $message")
}

fun main() {
    log("Start")

    var launchOneTimeMillis: Long = 0
    var launchTwoTimeMillis: Long = 0

    val totalTime = measureTimeMillis {
        runBlocking {
            log("RunBlocking start")

            launch() {
                launchOneTimeMillis = measureTimeMillis {
                    log("Launch 1 start")
                    myBlockingSuspendFunction()
                    log("Launch 1 end")
                }
            }

            launch {
                launchTwoTimeMillis = measureTimeMillis {
                    log("Launch 2 start")
                    repeat(5) {
                        delay(600)
                        log("Launch 2: repetition $it")
                    }
                    log("Launch 2 end")
                }
            }

            log("RunBlocking end")
        }
    }

    log("Times: Total = $totalTime | Launch 1 = $launchOneTimeMillis | Launch 2 = $launchTwoTimeMillis")
    log("End")

}

suspend fun myBlockingSuspendFunction() {
    log("MyFunction start")
    withContext(Dispatchers.Default) { // Comentar para hacer bloqueante
        Thread.sleep(3000) // Simula una tarea bloquenate pesada.
    }
    log("MyFunction end")
}